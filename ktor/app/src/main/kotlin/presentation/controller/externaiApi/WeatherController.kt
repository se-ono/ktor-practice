package com.example.presentation.controller.externaiApi

import com.example.application.usecase.externalApi.WeatherUseCase
import com.example.infrastructure.api.WeatherResponse

class WeatherController(private val useCase: WeatherUseCase) {
    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        return useCase.execute(lat, lon)
    }
}