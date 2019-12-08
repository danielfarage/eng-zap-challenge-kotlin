package com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories

import com.farage.daniel.eng_zap_challenge_kotlin.data.model.responses.ApartmentResponse

interface ApartmentsRepository {

    suspend fun getAllApartmentsRemote() : List<ApartmentResponse>

}