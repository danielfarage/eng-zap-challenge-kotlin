package com.farage.daniel.eng_zap_challenge_kotlin.data.local.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.farage.daniel.eng_zap_challenge_kotlin.data.local.Dao.ApartmentDao
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Converters

@Database(entities = [ApartmentEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ApartmentDatabase : RoomDatabase() {
    abstract fun apartmentDao() : ApartmentDao
}