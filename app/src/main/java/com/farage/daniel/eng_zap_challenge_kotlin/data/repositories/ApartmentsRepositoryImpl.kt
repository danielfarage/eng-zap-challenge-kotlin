package com.farage.daniel.eng_zap_challenge_kotlin.data.repositories

import androidx.paging.DataSource
import com.farage.daniel.eng_zap_challenge_kotlin.data.local.database.ApartmentDatabase
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.responses.ApartmentResponse
import com.farage.daniel.eng_zap_challenge_kotlin.data.network.Api
import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.VIVA_REAL
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.ZAP
import retrofit2.HttpException
import retrofit2.Retrofit

class ApartmentsRepositoryImpl(
    private val backendClient: Api,
    private val apartmentDatabase: ApartmentDatabase
) : ApartmentsRepository {

    override suspend fun getAllApartmentsRemote(): List<ApartmentResponse> {
        return try {
            backendClient.getAllApartments()
        } catch (e: HttpException) {
            emptyList()
        }
    }

    override suspend fun saveAllApartments(apartmentList: List<ApartmentEntity>): List<Long> {
        return try {
            apartmentDatabase.apartmentDao().createAll(apartmentList)
        }catch (error:Exception) {
            emptyList()
        }
    }

    override fun retriveAllApartmentsForZap(): DataSource.Factory<Int, ApartmentEntity> {
        return apartmentDatabase.apartmentDao().getAllApartmentPagedForZap(ZAP)
    }

    override fun retriveAllApartmentsForVivaReal(): DataSource.Factory<Int, ApartmentEntity> {
        return apartmentDatabase.apartmentDao().getAllApartmentPagedForVivaReal(VIVA_REAL)
    }
}