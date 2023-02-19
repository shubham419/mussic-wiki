package com.example.musicwiki.models.track

import com.example.musicwiki.models.common.Image

data class Track(
    val attr: AttrX,
    val artist: Artist,
    val duration: String,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: Streamable,
    val url: String
)