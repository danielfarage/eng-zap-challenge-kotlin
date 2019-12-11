package com.farage.daniel.eng_zap_challenge_kotlin.domain.usecases

import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.domain.repositories.ApartmentsRepository
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.MAX_LAT
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.MAX_LON
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.MIN_LAT
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.MIN_LON
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.RENTAL
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.SALE
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.VIVA_REAL
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.ZAP
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.toEntity
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class GetAllApartmentsUseCase(private val apartmentsRepository: ApartmentsRepository) {

    suspend fun launch(): ScreenState<Boolean> {
        val apartmentResponseList = withContext(Dispatchers.IO) {
            apartmentsRepository.getAllApartmentsRemote()
        }
        val apartmentEntityForVivaReal: List<ApartmentEntity> = apartmentResponseList.filter {
                    (
                            it.address.geoLocation.location.lat >= MIN_LAT &&
                            it.address.geoLocation.location.lon >= MIN_LON &&
                            it.address.geoLocation.location.lat <= MAX_LAT &&
                            it.address.geoLocation.location.lon <= MAX_LON &&
                            (it.pricingInfos.businessType == RENTAL && it.pricingInfos.rentalTotalPrice <= 5250)
                    ) or
                    (
                            it.pricingInfos.businessType == RENTAL &&
                            it.pricingInfos.rentalTotalPrice <= 4000 &&
                            it.pricingInfos.monthlyCondoFee <= (it.pricingInfos.rentalTotalPrice * 0.3)
                    ) or
                    (
                            it.pricingInfos.businessType == SALE && it.pricingInfos.price <= 700000
                    )
        }.map {
            it.toEntity().apply { enableFor = VIVA_REAL }
        }

        val apartmentEntityForZap: List<ApartmentEntity> = apartmentResponseList.filter {
                (
                            it.address.geoLocation.location.lat >= MIN_LAT &&
                            it.address.geoLocation.location.lon >= MIN_LON &&
                            it.address.geoLocation.location.lat <= MAX_LAT &&
                            it.address.geoLocation.location.lon <= MAX_LON &&
                            (it.pricingInfos.businessType == SALE && it.pricingInfos.price >= 560000)
                    ) or
                    (
                            it.pricingInfos.businessType == RENTAL &&
                            it.pricingInfos.rentalTotalPrice >= 3500
                    ) or
                    (
                            it.pricingInfos.businessType == SALE && it.pricingInfos.price >= 600000
                    )
        }.map { it.toEntity().apply { enableFor = ZAP } }
        var actualState: ScreenState<Boolean> = ScreenState.Loading()
        withContext(Dispatchers.IO) {
            actualState = try {
                apartmentsRepository.saveAllApartments(apartmentEntityForZap)
                apartmentsRepository.saveAllApartments(apartmentEntityForVivaReal)
                ScreenState.Success(true)
            }catch (error: Exception){
                ScreenState.Failure(error)
            }
        }
        return actualState
    }

}