package com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases

import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetAllApartmentsUseCaseTest {

    private val repositoryMockk = mockk<ApartmentsRepository>(relaxed = true)
    private lateinit var getAllApartmentsUseCase: GetAllApartmentsUseCase

    @Before
    fun setup() {
        getAllApartmentsUseCase = spyk(GetAllApartmentsUseCase(repositoryMockk))
    }

    @Test
    fun launchUseCase_shouldCallRepository() = runBlocking {
        coEvery { repositoryMockk.getAllApartmentsRemote() } returns mockk(relaxed = true)

        getAllApartmentsUseCase.launch()

        coVerify { repositoryMockk.getAllApartmentsRemote() }
    }

}