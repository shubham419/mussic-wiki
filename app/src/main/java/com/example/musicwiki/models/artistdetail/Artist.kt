package com.example.musicwiki.models.artistdetail

import com.example.musicwiki.models.common.Image

data class Artist(
    val bio: Bio,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val ontour: String,
    val similar: Similar,
    val stats: Stats,
    val streamable: String,
    val tags: Tags,
    val url: String
)