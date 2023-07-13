package com.example.androidrendu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidrendu.data.repository.RecipeRepository

class MyViewModelFactory constructor(private val recipeRepository: RecipeRepository):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RecipeViewModel::class.java)) {
            RecipeViewModel(this.recipeRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}