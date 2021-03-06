package com.farage.daniel.eng_zap_challenge_kotlin.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.farage.daniel.eng_zap_challenge_kotlin.data.local.dao.ApartmentDao
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Converters

@Database(entities = [ApartmentEntity::class], version = 3, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ApartmentDatabase : RoomDatabase() {
    abstract fun apartmentDao() : ApartmentDao
}