package com.mohamedkhalifa.simplephotos.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object PhotoLoader {
    fun loadPhoto(context: Context, imageView: ImageView, url: String) {
        Glide.with(context)
                .load(url)
                .into(imageView)
    }
}