package com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories

import androidx.paging.DataSource
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.responses.ApartmentResponse

interface ApartmentsRepository {

    suspend fun getAllApartmentsRemote() : List<ApartmentResponse>

    suspend fun saveAllApartments(apartmentList: List<ApartmentEntity>) : List<Long>

    fun retriveAllApartmentsForZap() : DataSource.Factory<Int, ApartmentEntity>

    fun retriveAllApartmentsForVivaReal() : DataSource.Factory<Int, ApartmentEntity>

}