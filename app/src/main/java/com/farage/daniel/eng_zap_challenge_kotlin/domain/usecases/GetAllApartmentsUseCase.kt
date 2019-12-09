package com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases

import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.toEntity
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.toPresenter
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllApartmentsUseCase(val apartmentsRepository: ApartmentsRepository) {

    suspend fun launch() : List<Long> {
        val apartmentResponseList = withContext(Dispatchers.IO) {
            apartmentsRepository.getAllApartmentsRemote()
        }
        val apartmentEntity: List<ApartmentEntity> = apartmentResponseList.map {
            it.toEntity()
        }

        return withContext(Dispatchers.IO) {
            apartmentsRepository.saveAllApartments(apartmentEntity)
        }
    }

}