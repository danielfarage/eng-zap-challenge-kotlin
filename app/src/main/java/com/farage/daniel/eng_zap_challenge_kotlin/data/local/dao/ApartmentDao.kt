package com.farage.daniel.eng_zap_challenge_kotlin.data.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.VIVA_REAL
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.ZAP

@Dao
interface ApartmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createAll(apartmentList: List<ApartmentEntity>) : List<Long>

    @Query("SELECT * FROM ApartmentEntity WHERE enableFor = :company AND lat <> 0 AND lon <> 0 AND usableAreas > 0 ")
    fun getAllApartmentPagedForZap(company: String) : DataSource.Factory<Int, ApartmentEntity>

    @Query("SELECT * FROM ApartmentEntity WHERE enableFor = :company AND lat <> 0 AND lon <> 0 AND usableAreas > 0 ")
    fun getAllApartmentPagedForVivaReal(company: String) : DataSource.Factory<Int, ApartmentEntity>

    @Query("SELECT * FROM ApartmentEntity WHERE id = :id")
    fun getSingleApartment(id: Int) :  ApartmentEntity
}