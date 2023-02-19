package com.example.musicwiki.models.album

import com.example.musicwiki.models.common.Image

data class Album(
    val attr: AttrX,
    val artist: Artist,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val url: String
)