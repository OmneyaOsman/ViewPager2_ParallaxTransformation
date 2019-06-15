package com.omni.viewpager2.feature.recipeshome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.omni.viewpager2.R
import com.omni.viewpager2.databinding.RecipeItemBinding
import com.omni.viewpager2.entities.Recipe


class RecipesViewPagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {
    var recipes: List<Recipe> = emptyList()
        set(value) {
            field = value
            // For an extra challenge, update this to use the paging library.

            // Notify any registered observers that the data set has changed. This will cause every
            // element in our RecyclerView to be invalidated.
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PagerViewHolder {
        val withDataBinding: RecipeItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            PagerViewHolder.LAYOUT, parent, false
        )
        return PagerViewHolder(withDataBinding)
    }

    override fun getItemCount() = recipes.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.recipe = recipes[position]
        }
    }
}

class PagerViewHolder(val viewDataBinding: RecipeItemBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.recipe_item
    }
}