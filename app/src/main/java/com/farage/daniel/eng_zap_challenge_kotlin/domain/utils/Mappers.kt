package com.farage.daniel.eng_zap_challenge_kotlin.domain.utils

import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.Address as EntityAddress
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.GeoLocation as EntityGeoLocation
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.Location as EntityLocation
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.PricingInfos as EntityPricingInfos
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.responses.ApartmentResponse
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.GeoLocation as PresenterGeoLocation
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Address as PresenterAdress
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Location as PresenterLocation
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.PricingInfos as PresenterPricingInfos

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
        PresenterAdress(
            this.address.city,
            this.address.neighborhood,
            PresenterGeoLocation(
                this.address.geoLocation.precision,
                PresenterLocation(
                    this.address.geoLocation.location.lon,
                    this.address.geoLocation.location.lat
                )
            )
        ),
        this.bathrooms,
        this.bedrooms,
        PresenterPricingInfos(
            this.pricingInfos.yearlyIptu,
            this.pricingInfos.price,
            this.pricingInfos.businessType,
            this.pricingInfos.monthlyCondoFee
        )
    )
}

fun ApartmentResponse.toEntity() : ApartmentEntity {
    return ApartmentEntity(
        this.id,
        this.usableAreas,
        this.listingType,
        this.createdAt,
        this.listingStatus,
        this.parkingSpaces,
        this.updatedAt,
        this.owner,
        this.images,
        EntityAddress(
            this.address.city,
            this.address.neighborhood,
            EntityGeoLocation(
                this.address.geoLocation.precision,
                EntityLocation(
                    this.address.geoLocation.location.lon,
                    this.address.geoLocation.location.lat
                )
            )
        ),
        this.bathrooms,
        this.bedrooms,
        EntityPricingInfos(
            this.pricingInfos.yearlyIptu,
            this.pricingInfos.price,
            this.pricingInfos.businessType,
            this.pricingInfos.monthlyCondoFee
        )
    )
}

fun ApartmentEntity.toPresenter() : Apartment {
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
        PresenterAdress(
            this.address.city,
            this.address.neighborhood,
            PresenterGeoLocation(
                this.address.geoLocation.precision,
                PresenterLocation(
                    this.address.geoLocation.location.lon,
                    this.address.geoLocation.location.lat
                )
            )
        ),
        this.bathrooms,
        this.bedrooms,
        PresenterPricingInfos(
            this.pricingInfos.yearlyIptu,
            this.pricingInfos.price,
            this.pricingInfos.businessType,
            this.pricingInfos.monthlyCondoFee
        )
    )
}