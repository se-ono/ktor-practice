package com.example.infrastructure.api

import kotlinx.serialization.Serializable

@Serializable
data class GeocodeResponse(
    val coordinate: Coordinate? = null
)

@Serializable
data class Coordinate(
    val lat: Double,
    val lng: Double
)

class GeocodingApiClient(private val httpClient: ExternalHttpClient)
{
    suspend fun fetchCoordinate(query: String): Coordinate? {
        val xml = httpClient.getText(
            url = "https://www.geocoding.jp/api/",
            queryParams = mapOf("q" to query)
        )

        val lat = Regex("<lat>(.*?)</lat>").find(xml)?.groupValues?.get(1)?.toDoubleOrNull()
        val lng = Regex("<lng>(.*?)</lng>").find(xml)?.groupValues?.get(1)?.toDoubleOrNull()

        return if (lat != null && lng != null) Coordinate(lat, lng) else null
    }
}
