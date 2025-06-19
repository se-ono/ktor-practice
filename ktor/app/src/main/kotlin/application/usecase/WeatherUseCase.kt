package com.example.application.usecase

import com.example.infrastructure.api.WeatherApiClient
import com.example.infrastructure.api.WeatherResponse

class WeatherUseCase(private val apiClient: WeatherApiClient) {
    suspend fun execute(lat: Double, lon: Double): WeatherResponse {
        return apiClient.getWeatherForecast(lat, lon)
    }
}