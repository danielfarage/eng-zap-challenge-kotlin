package com.farage.daniel.eng_zap_challenge_kotlin.data.repositories

import androidx.paging.DataSource
import com.farage.daniel.eng_zap_challenge_kotlin.data.local.database.ApartmentDatabase
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.responses.ApartmentResponse
import com.farage.daniel.eng_zap_challenge_kotlin.data.network.Api
import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import retrofit2.HttpException
import retrofit2.Retrofit

class ApartmentsRepositoryImpl(
    private val backendClient: Api,
    private val apartmentDatabase: ApartmentDatabase
) : ApartmentsRepository {

    override suspend fun getAllApartmentsRemote(): List<ApartmentResponse> {
        try {
            return backendClient.getAllApartments()
        } catch (e: HttpException) {
            return emptyList()
        }
    }

    override suspend fun saveAllApartments(apartmentList: List<ApartmentEntity>): List<Long> {
        return apartmentDatabase.apartmentDao().createAll(apartmentList)
    }

    override fun retriveAllApartmentsForZap(): DataSource.Factory<Int, ApartmentEntity> {
        return apartmentDatabase.apartmentDao().getAllApartmentPagedForZap()
    }

    override fun retriveAllApartmentsForVivaReal(): DataSource.Factory<Int, ApartmentEntity> {
        return apartmentDatabase.apartmentDao().getAllApartmentPagedForVivaReal()
    }
}