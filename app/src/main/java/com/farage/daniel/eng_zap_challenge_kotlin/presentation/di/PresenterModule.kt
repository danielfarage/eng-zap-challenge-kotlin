package com.farage.daniel.eng_zap_challenge_kotlin.presentation.di

import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.CompanyHolder
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentspannel.ApartmentsPannelViewModel
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresenterModule {
    val modules = module {
        viewModel { HomeViewModel(get()) }
        viewModel { ApartmentsPannelViewModel(get()) }
    }
}