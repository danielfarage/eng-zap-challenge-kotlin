package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases.GetAllApartmentsUseCase
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.ScreenState
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAllApartmentsUseCase: GetAllApartmentsUseCase
) : ViewModel() {

    private val _apartmentsAdded = MutableLiveData<ScreenState<Boolean>>()
    val apartmentsAdded: LiveData<ScreenState<Boolean>> = _apartmentsAdded

    fun loadApartments() {
        _apartmentsAdded.postValue(ScreenState.Loading())
        viewModelScope.launch {
            val loadingApartments = getAllApartmentsUseCase.launch()
                _apartmentsAdded.value = loadingApartments
        }
    }
}