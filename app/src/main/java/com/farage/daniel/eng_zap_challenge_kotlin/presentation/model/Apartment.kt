package com.farage.daniel.eng_zap_challenge_kotlin.presentation.model

data class Apartment(
    val id: String,
    val usableAreas: Int,
    val listingType: String,
    val createdAt: String,
    val listingStatus: String,
    val parkingSpaces: Int,
    val updatedAt: String,
    val owner: Boolean,
    val images: List<String>,
    val address: Address,
    val bathrooms: Int,
    val bedrooms: Int,
    val pricingInfos: PricingInfos
)

data class Address(

    val city: String,
    val neighborhood: String,
    val geoLocation: GeoLocation
)

data class Location(

    val lon: Double,
    val lat: Double
)

data class PricingInfos(

    val yearlyIptu: Int,
    val price: Int,
    val businessType: String,
    val monthlyCondoFee: Int
)

data class GeoLocation(

    val precision: String,
    val location: Location
)