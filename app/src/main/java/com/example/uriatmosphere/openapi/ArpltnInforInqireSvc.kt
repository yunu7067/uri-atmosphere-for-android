package com.example.uriatmosphere.openapi

import com.example.uriatmosphere.common.HttpRequest
import com.example.uriatmosphere.openapi.model.MsrstnAcctoRltmMesureDnstyData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

enum class DataTerm(val value: String) {
    DEFAULT("DAILY"),
    DAILY("DAILY"),
    MONTH("MONTH"),
    THREE_MONTH("3MONTH");
}

enum class Ver(val value: String) {
    DEFAULT("1.0"),
    NONE(""),
    V1_0("1.0"),
    V1_1("1.1"),
    V1_2("1.2"),
    V1_3("1.3");
}

/**
 * @param serviceKey 서비스키
 * @param returnType (Optional) 데이터 표출방식 xml 또는 json
 * @param numOfRows (Optional) 한 페이지 결과 수
 * @param pageNo (Optional) 페이지 번호
 * @param stationName 측정소 이름
 * @param dataTerm 요청 데이터기간(1일: DAILY, 1개월: MONTH, 3개월: 3MONTH)
 * @param ver (Optional) 버전별 상세 결과
 *
 * */
data class ArpltnInforInqireSvcOpts(
    val serviceKey: String,
    val returnType: String = "json",
    val numOfRows: Int = 100,
    val pageNo: Int = 1,
    val stationName: String,
    val dataTerm: String = DataTerm.DEFAULT.value,
    val ver: String = Ver.DEFAULT.value
) {
    fun toMap(): Map<String, String> {
        return mapOf(
            "serviceKey" to serviceKey,
            "returnType" to returnType,
            "numOfRows" to numOfRows.toString(),
            "pageNo" to pageNo.toString(),
            "stationName" to stationName,
            "dataTerm" to dataTerm,
            "ver" to ver
        )
    }
}


class ArpltnInforInqireSvc {
    private val endPoint: String = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc"
    private val serviceKey: String =
        "FrMV6GpXI+4xpWml1ydF3UFiKrJFnxJ7GU8LHv1jcSL10btjNKWC2mnOrfL8npLD4w57VBRBg+rTt5fKQ3+7nw=="
    private val options: ArpltnInforInqireSvcOpts

    init {
        ArpltnInforInqireSvcOpts(
            serviceKey = serviceKey,
            stationName = "전주시",
            ver = Ver.V1_1.value,
        ).also { options = it }
    }

    inner class MsrstnAcctoRltmMesureDnsty {
        private val requestUri = "${endPoint}/getMsrstnAcctoRltmMesureDnsty"

        fun get(): MsrstnAcctoRltmMesureDnstyData {
            val http = HttpRequest()
            val res = http.get(requestUri, "test")


            return Json { coerceInputValues = true }
                .decodeFromString<MsrstnAcctoRltmMesureDnstyData>(res)

        }

    }
}