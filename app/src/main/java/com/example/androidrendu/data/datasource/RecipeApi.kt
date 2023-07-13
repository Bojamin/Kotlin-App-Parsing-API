package com.example.androidrendu.data.datasource

import android.util.Log
import com.example.androidrendu.data.model.Recipe
import com.example.androidrendu.service.RecipeService

class RecipeApi(private val recipeService: RecipeService) {
    suspend fun fetchRecipeList(): List<Recipe> {
        val response = recipeService.fetchAllRecipe()
        Log.e("recipe","${response.body()}")
        return response.body()!!
    }
}