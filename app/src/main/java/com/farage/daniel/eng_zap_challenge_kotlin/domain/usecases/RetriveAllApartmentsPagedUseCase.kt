package com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagedList.Config.MAX_SIZE_UNBOUNDED
import androidx.paging.toLiveData
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.PAGE_SIZE
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.toPresenter
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.CompanyHolder
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetriveAllApartmentsPagedUseCase(private val apartmentsRepository: ApartmentsRepository) {

    fun launch(companyHolder: CompanyHolder): LiveData<PagedList<Apartment>> {
        val resultApartmentsList = when (companyHolder) {
                CompanyHolder.VIVA_REAL -> apartmentsRepository.retriveAllApartmentsForVivaReal()
                CompanyHolder.ZAP -> apartmentsRepository.retriveAllApartmentsForZap()
            }

        val pagedConfig = PagedList.Config.Builder().apply {
            setEnablePlaceholders(true)
            setPageSize(20)
            setInitialLoadSizeHint(20)
            setPrefetchDistance(20)
        }.build()
        return resultApartmentsList
            .map { it.toPresenter() }
            .toLiveData(pagedConfig)
    }

}