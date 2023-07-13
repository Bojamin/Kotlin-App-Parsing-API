package com.example.androidrendu

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidrendu.data.model.Recipe
import com.example.androidrendu.data.repository.RecipeRepository
import com.example.androidrendu.network.NetworkState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class RecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {

    val recipeList = MutableLiveData<List<Recipe>>()
    val loading = MutableLiveData<Boolean>()

    private var exceptionHandler = CoroutineExceptionHandler{
            _, throwable -> onError(throwable.message)
    }

    fun fetchAllRecipeList(){
        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            val response = recipeRepository.fetchRecipeList()
            loading.value = false
            recipeList.postValue(response)
        }
    }

    private fun onError(message : String?){
        loading.value = false
    }

}