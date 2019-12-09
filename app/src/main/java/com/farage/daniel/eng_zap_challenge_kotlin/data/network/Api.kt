package com.farage.daniel.eng_zap_challenge_kotlin.data.network

import com.farage.daniel.eng_zap_challenge_kotlin.data.model.responses.ApartmentResponse
import retrofit2.http.GET

interface Api {

    @GET("sources/source-1.js")
    suspend fun getAllApartments() : List<ApartmentResponse>

}