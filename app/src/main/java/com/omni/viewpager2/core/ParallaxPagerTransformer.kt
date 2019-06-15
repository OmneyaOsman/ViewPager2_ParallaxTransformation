package com.omni.viewpager2.core

import android.view.View
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2


class ParallaxPagerTransformer(private val viewId: Int) : ViewPager2.PageTransformer {

    override fun transformPage(view: View, position: Float) {

        view.apply {
            val parallaxView = findViewById<ImageView>(viewId)
            when {
                position < -1 -> // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    view.alpha = 1f
                position <= 1 -> { // [-1,1]
                    parallaxView.translationX = -position * (width / 2) //Half the normal speed
                }
                else -> // (1,+Infinity]
                    // This page is way off-screen to the right.
                    view.alpha = 1f
            }
        }
    }
}