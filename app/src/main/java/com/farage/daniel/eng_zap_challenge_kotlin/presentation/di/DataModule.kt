package com.farage.daniel.eng_zap_challenge_kotlin.presentation.di

import com.farage.daniel.eng_zap_challenge_kotlin.data.network.Api
import com.farage.daniel.eng_zap_challenge_kotlin.data.network.RetrofitClient
import org.koin.dsl.module

object DataModule {
    val modules = module {
        single { RetrofitClient.setup.create(Api::class.java) }
    }
}