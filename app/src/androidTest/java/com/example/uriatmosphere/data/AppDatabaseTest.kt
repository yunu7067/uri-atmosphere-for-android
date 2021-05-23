package com.example.uriatmosphere.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uriatmosphere.data.apicache.StationCache
import com.example.uriatmosphere.data.apicache.StationCacheDao
import com.example.uriatmosphere.data.favoritestation.FavoriteStation
import com.example.uriatmosphere.data.favoritestation.FavoriteStationDao
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {
    private lateinit var favoriteStationDao: FavoriteStationDao
    private lateinit var stationCacheDao: StationCacheDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room
            .inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .build()
        favoriteStationDao = db.favoriteStationDao()
        stationCacheDao = db.stationCacheDao()
    }


    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun favoriteStationTableWriteAndReadTest() {
        val favSt = FavoriteStation(order = 0, stationName = "삼천동")
        val favSt1 = FavoriteStation(order = 1, stationName = "삼천동2")
        val favSt2 = FavoriteStation(order = 2, stationName = "삼천동3")
        val favSt3 = FavoriteStation(order = 3, stationName = "삼천동4")
        val favSt4 = FavoriteStation(order = 4, stationName = "삼천동5")
        val favSt5 = FavoriteStation(order = 5, stationName = "삼천동6")
        val favSt6 = FavoriteStation(order = 6, stationName = "삼천동7")
        val favSt7 = FavoriteStation(order = 7, stationName = "삼천동8")

        favoriteStationDao.insert(favSt, favSt1, favSt2, favSt3, favSt4, favSt5, favSt6, favSt7)

        val byName = favoriteStationDao.getAll()

        Log.d("favoriteStationTableWriteAndReadTest", byName.toString())

        assertEquals(byName[0], favSt)
        assertEquals(byName[2].uid, 3)
        assertEquals(byName[6].order, 6)
        assertEquals(byName[4].stationName, "삼천동5")
    }

    @Test
    @Throws(Exception::class)
    fun stationCacheTableWriteAndReadTest() {
        val stCache = StationCache(stationName = "삼천동")

        stationCacheDao.insert(stCache)

        val caches = stationCacheDao.getAll()

        Log.d("stationCacheTableWriteAndReadTest", caches.toString())

        assertEquals(caches[0], stCache)
    }

}