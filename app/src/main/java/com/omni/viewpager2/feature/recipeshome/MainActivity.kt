package com.omni.viewpager2.feature.recipeshome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.omni.viewpager2.R
import com.omni.viewpager2.core.ParallaxPagerTransformer
import com.omni.viewpager2.databinding.ActivityMainBinding
import com.omni.viewpager2.entities.Recipe


class MainActivity : AppCompatActivity() {

    private lateinit var recipesAdapter: RecipesViewPagerAdapter
    private val viewModel: RecipesViewModel by lazy {
        ViewModelProviders.of(this).get(RecipesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.recipesViewModel = viewModel

        recipesAdapter = RecipesViewPagerAdapter()
        with(binding.root.findViewById<ViewPager2>(R.id.recipes_view_pager)){
            adapter = recipesAdapter
            setPageTransformer(ParallaxPagerTransformer(R.id.recipe_image))
        }

        viewModel.list.observe(this, Observer<List<Recipe>> { recipes ->
            recipes?.apply {
                recipesAdapter.recipes = recipes
            }
        })    }
}
