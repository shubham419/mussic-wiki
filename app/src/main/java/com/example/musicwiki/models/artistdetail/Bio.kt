package com.example.musicwiki.models.artistdetail

data class Bio(
    val content: String,
    val links: Links,
    val published: String,
    val summary: String
)