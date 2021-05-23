package com.example.uriatmosphere.data.favoritestation

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoriteStationDao {
    @Query("SELECT * FROM favorites")
    fun getAll(): List<FavoriteStation>

    @Insert
    fun insert(vararg favoriteStation: FavoriteStation)

    @Update
    fun updateOrder(vararg favoriteStation: FavoriteStation)

    @Delete
    fun delete(favoriteStation: FavoriteStation)
}
