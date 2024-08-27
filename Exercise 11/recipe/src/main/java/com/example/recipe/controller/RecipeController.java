package com.example.recipe.controller;

import com.example.recipe.model.Recipe;
import org.springframework.web.bind.annotation.*;
import com.example.recipe.service.RecipeService;

import java.util.*;
@RestController
public class RecipeController {
    RecipeService recipeService = new RecipeService();

    @GetMapping("/recipes")
    public ArrayList<Recipe> getAllRecipes(){
        return recipeService.getRecipeList();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable int id){
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }

    @PutMapping("/recipes/{id}")
    public Recipe removeRecipe(@PathVariable int id, @RequestBody Recipe recipe){
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable int id){
        recipeService.deleteRecipe(id);
    }

}
