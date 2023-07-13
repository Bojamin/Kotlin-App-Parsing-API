package com.example.androidrendu.service

import com.example.androidrendu.data.model.Recipe
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RecipeService {

    @GET("api/recipes")
    suspend fun fetchAllRecipe() : Response<List<Recipe>>

    companion object{
        var recipeService : RecipeService? = null
        fun getInstance() : RecipeService{
            if(recipeService == null){
                val recipe = Retrofit.Builder()
                    .baseUrl("https://cogno.fr/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                recipeService = recipe.create(RecipeService::class.java)
            }
            return recipeService!!
        }
    }
}