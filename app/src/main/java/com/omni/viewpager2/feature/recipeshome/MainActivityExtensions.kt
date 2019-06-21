package com.omni.viewpager2.feature.recipeshome

import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.recipe_item_page.view.*

fun ImageButton.setHopAnimationToButtonImage(){
    val animation = this
        .animate()
        .translationYBy(-40f)
        .setDuration(200)

    animation.withEndAction {
        this.animate().translationYBy(40f).duration = 200
    }
}

fun setParallaxTransformation(page: View, position: Float){
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