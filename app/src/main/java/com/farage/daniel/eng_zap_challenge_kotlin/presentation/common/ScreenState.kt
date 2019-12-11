package com.farage.daniel.eng_zap_challenge_kotlin.presentation.common

import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import java.lang.Exception

sealed class ScreenState<T> {
    class  Loading<T> : ScreenState<T>()
    data class Success<T>(val result: T) : ScreenState<T>()
    data class Failure<T>(val error: Exception) : ScreenState<T>()
}