package com.example.musicwiki.models.artists

import com.example.musicwiki.models.common.Image

data class Artist(
    val attr: AttrX,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)