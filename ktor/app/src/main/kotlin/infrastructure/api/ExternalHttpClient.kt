package com.example.infrastructure.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ExternalHttpClient(val client: HttpClient) {

    suspend fun getText(
        url: String,
        queryParams: Map<String, String> = emptyMap(),
        headers: Map<String, String> = emptyMap()
    ): String {
        return client.get(url) {
            headers.forEach { (k, v) -> header(k, v) }
            url {
                queryParams.forEach { (k, v) -> parameters.append(k, v) }
            }
        }.bodyAsText()
    }

    suspend inline fun <reified T> getJson(
        url: String,
        queryParams: Map<String, String> = emptyMap(),
        headers: Map<String, String> = emptyMap()
    ): T {
        return client.get(url) {
            headers.forEach { (k, v) -> header(k, v) }
            url {
                queryParams.forEach { (k, v) -> parameters.append(k, v) }
            }
        }.body()
    }

    suspend inline fun <reified T, reified R> postJson(
        url: String,
        body: T,
        headers: Map<String, String> = emptyMap()
    ): R {
        return client.post(url) {
            headers.forEach { (k, v) -> header(k, v) }
            contentType(ContentType.Application.Json)
            setBody(body)
        }.body()
    }

    // その他 PUT, DELETE なども必要に応じて追加
}
