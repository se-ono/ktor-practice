package com.example.presentation.handler

import com.example.presentation.controller.externaiApi.GeocodingController
import com.example.presentation.controller.externaiApi.WeatherController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

class ExternalApiHandler(
    private val geocodingController: GeocodingController,
    private val weatherController: WeatherController
) {
    suspend fun geocoding(call: ApplicationCall) {
        val query = call.request.queryParameters["q"]
        if (query.isNullOrBlank()) {
            call.respond(HttpStatusCode.BadRequest, "Missing 'q' parameter")
            return
        }

        val coordinate = geocodingController.geocoding(query)
        if (coordinate == null) {
            call.respond(HttpStatusCode.NotFound, "No coordinate found")
        } else {
            call.respond(coordinate)
        }
    }

    suspend fun getWeather(call: ApplicationCall) {
        val lat = call.request.queryParameters["lat"]?.toDoubleOrNull()
        val lon = call.request.queryParameters["lon"]?.toDoubleOrNull()

        if (lat == null || lon == null) {
            call.respond(HttpStatusCode.BadRequest, "lat and lon are required")
            return
        }

        val result = weatherController.getWeather(lat, lon)
        call.respond(result)
    }
}
