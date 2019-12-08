package com.farage.daniel.eng_zap_challenge_kotlin.presentation.common

import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import java.lang.Exception

sealed class ScreenState {
    object Loading : ScreenState()
    data class Success(val result: List<Apartment>) : ScreenState()
    data class Failure(val error: Exception) : ScreenState()
}