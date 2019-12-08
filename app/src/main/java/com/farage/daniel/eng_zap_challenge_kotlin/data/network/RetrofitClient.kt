package com.farage.daniel.eng_zap_challenge_kotlin.data.network

import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val setup: Retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl(Constants.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }
}