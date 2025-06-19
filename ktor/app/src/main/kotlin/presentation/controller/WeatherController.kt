package com.example.presentation.controller

import com.example.application.usecase.WeatherUseCase
import com.example.infrastructure.api.WeatherResponse

class WeatherController(private val useCase: WeatherUseCase) {
    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        return useCase.execute(lat, lon)
    }
}