package com.example.musicwiki.models.artisttoptrack

data class Track(
    val attr: AttrX,
    val artist: Artist,
    val image: List<Image>,
    val listeners: String,
    val mbid: String,
    val name: String,
    val playcount: String,
    val streamable: String,
    val url: String
)