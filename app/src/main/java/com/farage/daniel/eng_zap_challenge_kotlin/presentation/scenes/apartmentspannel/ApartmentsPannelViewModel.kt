package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentspannel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases.RetriveAllApartmentsPagedUseCase
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.CompanyHolder
import kotlinx.coroutines.*

class ApartmentsPannelViewModel(
    private val retriveAllApartmentsPagedUseCase: RetriveAllApartmentsPagedUseCase
) : ViewModel() {

    /*var allApartmentsPagedList: LiveData<PagedList<ApartmentEntity>> = viewModelScope.async {
        retriveAllApartmentsPagedUseCase.launch(companyHolder)
    }.getCompleted()*/

    fun retriveAllApartments(companyHolder: CompanyHolder): LiveData<PagedList<ApartmentEntity>> {
        return retriveAllApartmentsPagedUseCase.launch(companyHolder)
    }





}