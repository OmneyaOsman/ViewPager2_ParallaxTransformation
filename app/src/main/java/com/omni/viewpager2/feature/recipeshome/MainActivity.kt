package com.omni.viewpager2.feature.recipeshome

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.omni.viewpager2.R
import com.omni.viewpager2.entities.Recipe
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recipe_item_page.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var recipesAdapter: RecipesViewPagerAdapter
    private val viewModel: RecipesViewModel by lazy {
        ViewModelProviders.of(this).get(RecipesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recipesAdapter = RecipesViewPagerAdapter()
        with(recipes_view_pager) {
            adapter = recipesAdapter
            setPageTransformer { page, position ->
                setParallaxTransformation(page, position)
            }
        }

        viewModel.list.observe(this, Observer<List<Recipe>> { recipes ->
            recipes?.apply {
                recipesAdapter.recipes = recipes
            }
        })
    }

    private fun setParallaxTransformation(page: View, position: Float) {
        page.apply {
            val parallaxView = this.recipe_image
            when {
                position < -1 -> // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    alpha = 1f
                position <= 1 -> { // [-1,1]
                    parallaxView.translationX = -position * (width / 2) //Half the normal speed
                }
                else -> // (1,+Infinity]
                    // This page is way off-screen to the right.
                    alpha = 1f
            }
        }
    }
}
