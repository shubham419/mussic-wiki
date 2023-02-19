package com.example.musicwiki.models.artistdetail

import com.example.musicwiki.models.common.Image

data class ArtistX(
    val image: List<Image>,
    val name: String,
    val url: String
)