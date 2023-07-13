package com.example.androidrendu.data.repository

import com.example.androidrendu.data.model.Recipe

interface RecipeRepository {
    suspend fun fetchRecipeList() : List<Recipe>
}