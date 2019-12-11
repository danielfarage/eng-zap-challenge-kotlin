package com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases

import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.CompanyHolder
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class RetriveAllApartmentsPagedUseCaseTest{

    private val repositoryMockk = mockk<ApartmentsRepository>(relaxed = true)
    private lateinit var retriveAllApartmentsPagedUseCase: RetriveAllApartmentsPagedUseCase

    @Before
    fun setup() {
        retriveAllApartmentsPagedUseCase = spyk(RetriveAllApartmentsPagedUseCase(repositoryMockk))
    }

    @Test
    fun launchUseCase_shouldCallRepositoryForVivaReal() = runBlocking {
        every { repositoryMockk.retriveAllApartmentsForVivaReal() } returns mockk(relaxed = true)

        retriveAllApartmentsPagedUseCase.launch(CompanyHolder.VIVA_REAL)

        verify { repositoryMockk.retriveAllApartmentsForVivaReal() }
    }

    @Test
    fun launchUseCase_shouldCallRepositoryForZap() = runBlocking {
        every { repositoryMockk.retriveAllApartmentsForZap() } returns mockk(relaxed = true)

        retriveAllApartmentsPagedUseCase.launch(CompanyHolder.ZAP)

        verify { repositoryMockk.retriveAllApartmentsForZap() }
    }

}