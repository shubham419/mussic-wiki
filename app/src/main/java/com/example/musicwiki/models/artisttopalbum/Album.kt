package com.example.musicwiki.models.artisttopalbum

import com.example.musicwiki.models.common.Image

data class Album(
    val artist: Artist,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val playcount: Int,
    val url: String
)