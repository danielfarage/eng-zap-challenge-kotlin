package com.farage.daniel.eng_zap_challenge_kotlin.presentation.di

import com.farage.daniel.eng_zap_challenge_kotlin.data.repositories.ApartmentsRepositoryImpl
import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases.GetAllApartmentsUseCase
import com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases.RetriveAllApartmentsPagedUseCase
import org.koin.dsl.module

object DomainModule {
    val modules = module {
        single<ApartmentsRepository> { ApartmentsRepositoryImpl(get(), get()) }
        factory { GetAllApartmentsUseCase(get()) }
        factory { RetriveAllApartmentsPagedUseCase(get()) }
    }
}