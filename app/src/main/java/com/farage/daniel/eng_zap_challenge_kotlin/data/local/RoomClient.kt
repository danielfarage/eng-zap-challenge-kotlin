package com.farage.daniel.eng_zap_challenge_kotlin.data.local

import android.content.Context
import androidx.room.Room
import com.farage.daniel.eng_zap_challenge_kotlin.data.local.Database.ApartmentDatabase

class RoomClient(val context: Context) {
    val setupApartmentDatabase: ApartmentDatabase by lazy {
        Room.databaseBuilder(
            context,
            ApartmentDatabase::class.java,
            "ApartmentDatabase"
        ).build()
    }
}