package com.example.androidrendu

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrendu.adapter.RecipeAdapter
import com.example.androidrendu.data.datasource.RecipeApi
import com.example.androidrendu.data.repository.RecipeRepositoryImpl
import com.example.androidrendu.databinding.ActivityRecipeListBinding
import com.example.androidrendu.service.RecipeService

class RecipeListActivity : AppCompatActivity() {

    private lateinit var viewModel: RecipeViewModel
    lateinit var binding : ActivityRecipeListBinding
    private val recipeAdapter = RecipeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObjects()
        setAdapter()
        initObserver()

        viewModel.fetchAllRecipeList()
    }

    private fun initObjects() {
        val recipeService = RecipeService.getInstance()
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(RecipeRepositoryImpl(RecipeApi(recipeService)))
        )[RecipeViewModel::class.java]
    }

    private fun setAdapter(){
        binding.rvRecipe.adapter = recipeAdapter
    }

    private fun initObserver() {
        viewModel.recipeList.observe(this){
            recipeAdapter.setRecipes(it)
        }

        viewModel.loading.observe(this){
                isLoading ->
            if(isLoading) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        }
    }
}
