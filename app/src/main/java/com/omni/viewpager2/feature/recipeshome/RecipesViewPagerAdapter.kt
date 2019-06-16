package com.omni.viewpager2.feature.recipeshome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.omni.viewpager2.R
import com.omni.viewpager2.entities.Recipe
import kotlinx.android.synthetic.main.recipe_item_page.view.*


class RecipesViewPagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {
    var recipes: List<Recipe> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PagerViewHolder {
        return LayoutInflater.from(parent.context).inflate(
            PagerViewHolder.LAYOUT, parent, false
        ).let { PagerViewHolder(it) }
    }

    override fun getItemCount() = recipes.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(recipes[position])
    }
}

class PagerViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(recipe: Recipe) {
        root.recipe_title?.text = recipe.title
        root.recipe_image?.let {
            Glide.with(it.context)
                .load(recipe.imgResource)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                )
                .into(it)
        }
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.recipe_item_page
    }
}