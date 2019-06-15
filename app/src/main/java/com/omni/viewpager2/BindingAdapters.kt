package com.omni.viewpager2demo

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.omni.viewpager2.R


@BindingAdapter("imageRes")
fun ImageView.bindImage(imgResource :Int?){
    let {
        Glide.with(context)
            .load(imgResource)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(it)
    }

}