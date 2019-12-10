package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases.GetAllApartmentsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAllApartmentsUseCase: GetAllApartmentsUseCase
) : ViewModel() {

    private val apartmentsAdded = MutableLiveData<List<Long>>()

    fun loadApartments() {
        viewModelScope.launch {
            val loadingApartments = getAllApartmentsUseCase.launch()
            apartmentsAdded.value = loadingApartments
        }
    }
}