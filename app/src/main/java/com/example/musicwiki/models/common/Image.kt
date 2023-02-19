package com.example.musicwiki.models.common

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("#text" )
    var text : String?,
    val size: String
)