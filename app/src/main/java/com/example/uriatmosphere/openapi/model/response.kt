package com.example.uriatmosphere.openapi.model

import kotlinx.serialization.Serializable


@Serializable
data class MsrstnAcctoRltmMesureDnstyData(
    val response: Response,
)

@Serializable
data class Response(
    val header: Header,
    val body: Body,
)

@Serializable
data class Header(
    val resultCode: String,
    val resultMsg: String,
)

@Serializable
data class Body(
    val totalCount: Int,
    val items: List<Item>,
    val pageNo: Int,
    val numOfRows: Int,
)

@Serializable
data class Item(
    val stationName: String = "",
    val mangName: String = "",
    val sidoName: String = "",
    val dataTime: String = "",
    val so2Value: String = "",
    val coValue: String = "",
    val o3Value: String = "",
    val no2Value: String = "",
    val pm10Value: String = "",
    val pm10Value24: String = "",
    val pm25Value: String = "",
    val pm25Value24: String = "",
    val khaiValue: String = "",
    val khaiGrade: String = "",
    val so2Grade: String = "",
    val coGrade: String = "",
    val o3Grade: String = "",
    val no2Grade: String = "",
    val pm10Grade: String = "",
    val pm25Grade: String = "",
    val pm10Grade1h: String = "",
    val pm25Grade1h: String = "",
    val so2Flag: String = "",
    val coFlag: String = "",
    val o3Flag: String = "",
    val no2Flag: String = "",
    val pm10Flag: String = "",
    val pm25Flag: String = "",
)
