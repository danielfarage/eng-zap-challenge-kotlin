package com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases

import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.toPresenter
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllApartmentsUseCase(val apartmentsRepository: ApartmentsRepository) {

    suspend fun launch() : List<Apartment> {
        val apartmentResponseList = withContext(Dispatchers.IO) {
            apartmentsRepository.getAllApartmentsRemote()
        }
        return apartmentResponseList.map {
            it.toPresenter()
        }
    }

}