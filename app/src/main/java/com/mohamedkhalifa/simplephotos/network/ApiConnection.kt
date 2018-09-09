package com.learn.archwithkotlin.network

import com.mohamedkhalifa.simplephotos.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiConnection {
    private lateinit var retrofit: Retrofit

    fun getRetrofitCall(): Retrofit {
        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.FLICKR_URL)
                .build()
        return retrofit
    }
}