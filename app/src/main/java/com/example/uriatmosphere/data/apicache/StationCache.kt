package com.example.uriatmosphere.data.apicache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StationCache(
    @ColumnInfo(name = "station_name")
    val stationName: String,

    @ColumnInfo(name = "mang_name")
    val mangName: String? = "",

    @ColumnInfo(name = "sido_name")
    val sidoName: String? = "",

    @ColumnInfo(name = "data_time")
    val dataTime: String? = "",

    @ColumnInfo(name = "so2_value")
    val so2Value: String? = "",

    @ColumnInfo(name = "co_value")
    val coValue: String? = "",

    @ColumnInfo(name = "o3_value")
    val o3Value: String? = "",

    @ColumnInfo(name = "no2_value")
    val no2Value: String? = "",

    @ColumnInfo(name = "pm10_value")
    val pm10Value: String? = "",

    @ColumnInfo(name = "pm10_value24")
    val pm10Value24: String? = "",

    @ColumnInfo(name = "pm25_value")
    val pm25Value: String? = "",

    @ColumnInfo(name = "pm25_value24")
    val pm25Value24: String? = "",

    @ColumnInfo(name = "khai_value")
    val khaiValue: String? = "",

    @ColumnInfo(name = "khai_grade")
    val khaiGrade: String? = "",

    @ColumnInfo(name = "so2_grade")
    val so2Grade: String? = "",

    @ColumnInfo(name = "co_grade")
    val coGrade: String? = "",

    @ColumnInfo(name = "o3_grade")
    val o3Grade: String? = "",

    @ColumnInfo(name = "no2_grade")
    val no2Grade: String? = "",

    @ColumnInfo(name = "pm10_grade")
    val pm10Grade: String? = "",

    @ColumnInfo(name = "pm25_grade")
    val pm25Grade: String? = "",

    @ColumnInfo(name = "pm10_grade1h")
    val pm10Grade1h: String? = "",

    @ColumnInfo(name = "pm25_grade1h")
    val pm25Grade1h: String? = "",

    @ColumnInfo(name = "so2_flag")
    val so2Flag: String? = "",

    @ColumnInfo(name = "co_flag")
    val coFlag: String? = "",

    @ColumnInfo(name = "o3_flag")
    val o3Flag: String? = "",

    @ColumnInfo(name = "no2_flag")
    val no2Flag: String? = "",

    @ColumnInfo(name = "pm10_flag")
    val pm10Flag: String? = "",

    @ColumnInfo(name = "pm25_flag")
    val pm25Flag: String? = "",
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null
}