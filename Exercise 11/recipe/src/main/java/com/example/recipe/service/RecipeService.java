package com.example.recipe.service;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

public class RecipeService implements RecipeRepository{
    private static HashMap<Integer,Recipe> recipeBook = new HashMap<>();
    private int recipeUniqueCount = 6;

    public RecipeService() {
        recipeBook.put(1,new Recipe(1, "Pasta", "veg",
                        Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
        recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
        recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
        recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
        recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
    }
    @Override
    public ArrayList<Recipe> getRecipeList() {
        Collection<Recipe> recipes = recipeBook.values();
        return new ArrayList<>(recipes);
    }

    @Override
    public Recipe getRecipeById(int recipeId) {
        if(recipeBook.get(recipeId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            return recipeBook.get(recipeId);
        }
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipe.setRecipeId(recipeUniqueCount++);
        recipeBook.put(recipe.getRecipeId(), recipe);
        return recipe;
    }

    @Override
    public Recipe updateRecipe(int recipeId, Recipe recipe) {
        Recipe oldRecipe = recipeBook.get(recipeId);
        if(oldRecipe == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(recipe.getRecipeName() != null){
            oldRecipe.setRecipeName(recipe.getRecipeName());
        }

        if(recipe.getRecipeType()!= null){
            oldRecipe.setRecipeType(recipe.getRecipeType());
        }

        if(recipe.getIngredients()!= null){
            oldRecipe.setIngredients(recipe.getIngredients());
        }
        return oldRecipe;
    }

    @Override
    public void deleteRecipe(int recipeId) {
        if(recipeBook.get(recipeId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            recipeBook.remove(recipeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
