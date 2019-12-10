package com.farage.daniel.eng_zap_challenge_kotlin.presentation.di


object Modules {
    val allModules = arrayListOf(
        DomainModule.modules,
        DataModule.modules,
        PresenterModule.modules
    )
}