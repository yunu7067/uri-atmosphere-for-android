package com.example.uriatmosphere.data.apicache

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StationCacheDao {
    @Query("SELECT * FROM StationCache")
    fun getAll(): List<StationCache>

    @Insert
    fun insert(vararg stationCache: StationCache)


    @Query("DELETE FROM stationCache")
    fun deleteAll()
}
