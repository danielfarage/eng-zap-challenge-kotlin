package com.farage.daniel.eng_zap_challenge_kotlin.data.local.Dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity

@Dao
interface ApartmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createAll(apartmentList: List<ApartmentEntity>)

    @Query("SELECT * FROM ApartmentEntity")
    fun getAllApartmentPaged() : DataSource.Factory<Int, ApartmentEntity>
}