package com.example.androidrendu.data.repository

import com.example.androidrendu.data.datasource.RecipeApi
import com.example.androidrendu.data.model.Recipe

class RecipeRepositoryImpl(private val recipeApi: RecipeApi) : RecipeRepository {
    override suspend fun fetchRecipeList(): List<Recipe> {
        return recipeApi.fetchRecipeList()
    }
}