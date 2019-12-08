package com.farage.daniel.eng_zap_challenge_kotlin.domain.utils

import com.farage.daniel.eng_zap_challenge_kotlin.data.model.responses.ApartmentResponse
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.*

fun ApartmentResponse.toPresenter() : Apartment {
    return Apartment(
        this.id,
        this.usableAreas,
        this.listingType,
        this.createdAt,
        this.listingStatus,
        this.parkingSpaces,
        this.updatedAt,
        this.owner,
        this.images,
        Address(
            this.address.city,
            this.address.neighborhood,
            GeoLocation(
                this.address.geoLocation.precision,
                Location(
                    this.address.geoLocation.location.lon,
                    this.address.geoLocation.location.lat
                )
            )
        ),
        this.bathrooms,
        this.bedrooms,
        PricingInfos(
            this.pricingInfos.yearlyIptu,
            this.pricingInfos.price,
            this.pricingInfos.businessType,
            this.pricingInfos.monthlyCondoFee
        )
    )
}