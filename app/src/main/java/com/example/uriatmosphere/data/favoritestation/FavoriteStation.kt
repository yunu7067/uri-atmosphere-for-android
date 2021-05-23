package com.example.uriatmosphere.data.favoritestation

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")
data class FavoriteStation(
    @ColumnInfo(name = "order")
    val order: Int = 0,

    @ColumnInfo(name = "station_name")
    val stationName: String = "",
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null
}