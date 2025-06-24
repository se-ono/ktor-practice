package com.example.presentation.controller.externaiApi

import com.example.application.usecase.externalApi.GeocodingUseCase
import com.example.infrastructure.api.Coordinate

class GeocodingController(private val geocodingUseCase: GeocodingUseCase)
{
    suspend fun geocoding(query: String): Coordinate? {
        return geocodingUseCase.execute(query)
    }
}