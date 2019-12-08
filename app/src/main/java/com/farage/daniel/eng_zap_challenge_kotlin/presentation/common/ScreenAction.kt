package com.farage.daniel.eng_zap_challenge_kotlin.presentation.common

import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment

sealed class ScreenAction {
    object Load : ScreenAction()
    object BackButton : ScreenAction()
    data class LoadMore(val actualPage: Int, val resultPerPage: Int) : ScreenAction()
    data class ShowDetails(val apartment: Apartment) : ScreenAction()
}