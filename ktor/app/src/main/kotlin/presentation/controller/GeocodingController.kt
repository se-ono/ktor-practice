package com.example.presentation.controller

import com.example.application.usecase.GeocodingUseCase
import com.example.infrastructure.api.Coordinate

class GeocodingController(private val geocodingUseCase: GeocodingUseCase)
{
    suspend fun geocoding(query: String): Coordinate? {
        return geocodingUseCase.execute(query)
    }
}
