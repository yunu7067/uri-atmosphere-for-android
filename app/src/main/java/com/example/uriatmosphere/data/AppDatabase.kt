package com.example.uriatmosphere.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.uriatmosphere.data.apicache.StationCache
import com.example.uriatmosphere.data.apicache.StationCacheDao
import com.example.uriatmosphere.data.favoritestation.FavoriteStation
import com.example.uriatmosphere.data.favoritestation.FavoriteStationDao

@Database(entities = [StationCache::class, FavoriteStation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stationCacheDao(): StationCacheDao
    abstract fun favoriteStationDao(): FavoriteStationDao
}