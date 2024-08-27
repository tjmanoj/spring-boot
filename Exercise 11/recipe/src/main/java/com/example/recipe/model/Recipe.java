package com.example.recipe.model;

import java.util.*;

public class Recipe {
    private int recipeId;
    private String recipeName;
    private String recipeType;
    List<String> ingredients;

    public Recipe(int recipeId, String recipeName, String recipeType, List<String> ingredients) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeType = recipeType;
        this.ingredients = ingredients;
    }
    //getters
    public int getRecipeId() {
        return recipeId;
    }
    public String getRecipeName() {
        return recipeName;
    }
    public String getRecipeType() {
        return recipeType;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
    //setters
    public void setRecipeId(int id) {
        this.recipeId = id;
    }
    public void setRecipeName(String name) {
        this.recipeName = name;
    }
    public void setRecipeType(String type) {
        this.recipeType = type;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
