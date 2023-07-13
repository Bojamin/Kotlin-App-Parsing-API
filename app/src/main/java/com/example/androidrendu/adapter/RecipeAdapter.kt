package com.example.androidrendu.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidrendu.R
import com.example.androidrendu.data.model.Recipe
import com.example.androidrendu.databinding.AdapterRecyclerItemRecipeBinding

class RecipeAdapter : RecyclerView.Adapter<RecipeViewHolder>() {

    private var recipeList = mutableListOf<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRecyclerItemRecipeBinding.inflate(inflater, parent, false)
        return RecipeViewHolder(binding)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.binding.recipeName.text = recipe.Name.trim()
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    fun setRecipes(recipeList: List<Recipe>){
        this.recipeList = recipeList.toMutableList()
        notifyDataSetChanged()
    }
}

class RecipeViewHolder(val binding : AdapterRecyclerItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {}