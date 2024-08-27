package com.example.recipe.repository;

import com.example.recipe.model.Recipe;
import java.util.ArrayList;

public interface RecipeRepository {
    public ArrayList<Recipe> getRecipeList();
    public Recipe getRecipeById(int recipeId);
    public Recipe addRecipe(Recipe recipe);
    public Recipe updateRecipe(int recipeId, Recipe recipe);
    public void deleteRecipe(int recipeId);
}
