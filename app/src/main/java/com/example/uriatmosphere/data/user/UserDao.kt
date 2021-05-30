package com.example.uriatmosphere.data.user

import com.example.uriatmosphere.data.favoritestation.FavoriteStation
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<U>

    @Insert
    fun insert(vararg favoriteStation: FavoriteStation)

    @Update
    fun updateOrder(vararg favoriteStation: FavoriteStation)

    @Delete
    fun delete(favoriteStation: FavoriteStation)
}
