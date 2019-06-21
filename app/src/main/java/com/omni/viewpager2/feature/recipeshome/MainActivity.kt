package com.omni.viewpager2.feature.recipeshome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.omni.viewpager2.R
import com.omni.viewpager2.entities.Recipe
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var recipesAdapter: RecipesViewPagerAdapter
    private val viewModel: RecipesViewModel by lazy {
        ViewModelProviders.of(this).get(RecipesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        overview_imgbut.setHopAnimationToButtonImage()

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

}
