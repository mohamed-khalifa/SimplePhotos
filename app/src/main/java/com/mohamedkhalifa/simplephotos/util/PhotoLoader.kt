package com.mohamedkhalifa.simplephotos.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

object PhotoLoader {
    fun loadPhoto(context: Context, imageView: ImageView, url: String) {
        Glide.with(context)
                .load(url)
                .transition(DrawableTransitionOptions().crossFade())
                .into(imageView)
    }
}