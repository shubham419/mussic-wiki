package com.example.musicwiki.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.musicwiki.R
import com.example.musicwiki.models.common.Image


@BindingAdapter("set_image")
fun loadImage(view: ImageView, imageUrl: List<Image>) {
    Glide.with(view.context)
        .load(imageUrl[3].text).apply(RequestOptions().circleCrop())
        .placeholder(R.drawable.artist_paceholder_img)
        .into(view)
}

@BindingAdapter("set_image_url")
fun loadImageUrl(view: ImageView, imageUrl: String) {
    Glide.with(view.context)
        .load(imageUrl).apply(RequestOptions().circleCrop())
        .placeholder(R.drawable.artist_paceholder_img)
        .into(view)
}