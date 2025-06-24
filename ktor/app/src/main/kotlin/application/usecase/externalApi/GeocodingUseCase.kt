package com.example.application.usecase.externalApi

import com.example.infrastructure.api.Coordinate
import com.example.infrastructure.api.GeocodingApiClient

class GeocodingUseCase (private val apiClient: GeocodingApiClient)
{
    suspend fun execute(query: String): Coordinate? {
        return apiClient.fetchCoordinate(query)
    }
}