package com.farage.daniel.eng_zap_challenge_kotlin.data.repositories

import com.farage.daniel.eng_zap_challenge_kotlin.data.model.responses.ApartmentResponse
import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository

class ApartmentsRepositoryImpl : ApartmentsRepository {
    override suspend fun getAllApartmentsRemote(): List<ApartmentResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}