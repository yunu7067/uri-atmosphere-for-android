package com.example.uriatmosphere.common

import android.util.Log
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import java.net.URLEncoder

data class HttpRequestOptions(
    val headers: Map<String, String> = mapOf(),
    val params: Map<String, String> = mapOf(),
    val body: Map<String, String> = mapOf(),
) {

    fun getQueryString(): String {
        var query = ""
        for ((key, value) in params) {
            query += "${key}=${URLEncoder.encode(value, "utf-8")}&"
        }
        query = query.substring(0, query.length - 1)
        return query
    }
}

class HttpRequest {
    private fun requestCall(request: Request): String {
        val client = OkHttpClient()
        val response = client.newCall(request).execute()
        return try {
            response.body?.string() ?: ""
        } catch (e: Exception) {
            Log.d("HttpRequest requestCall", e.toString())
            ""
        }
    }

    fun get(
        uri: String,
        options: HttpRequestOptions = HttpRequestOptions()
    ): String {
        val query = options.getQueryString()
        val fullUri = if (query.isBlank()) uri else "${uri}?${query}"
        val request = Request.Builder().url(fullUri).build()
        val response = requestCall(request);

        Log.d("HttpRequest fullUri", fullUri)
        Log.d("HttpRequest response", response)

        return response
    }


}