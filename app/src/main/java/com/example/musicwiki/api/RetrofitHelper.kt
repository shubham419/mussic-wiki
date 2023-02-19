package com.example.musicwiki.api

import com.example.musicwiki.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    @Volatile
    private var INSTANCE: Retrofit? = null

    fun getInstance(): Retrofit {
        if (INSTANCE == null) {
            synchronized(this) {
                INSTANCE = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
        }
        return INSTANCE!!
    }

}