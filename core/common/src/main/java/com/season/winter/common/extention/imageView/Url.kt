package com.season.winter.common.extention.imageView

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.setUrl(url: String) {
    if (url.isEmpty()) return
    Glide.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}