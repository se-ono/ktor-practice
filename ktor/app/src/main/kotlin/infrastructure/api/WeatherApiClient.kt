package com.example.infrastructure.api

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val hourly: HourlyData
)

@Serializable
data class HourlyData(
    val time: List<String>,
    val temperature_2m: List<Double>
)

class WeatherApiClient(private val client: ExternalHttpClient) {
    suspend fun getWeatherForecast(lat: Double, lon: Double): WeatherResponse {
        return client.getJson(
            url = "https://api.open-meteo.com/v1/forecast",
            queryParams = mapOf(
                "latitude" to lat.toString(),
                "longitude" to lon.toString(),
                "hourly" to "temperature_2m"
            )
        )
    }
}

