package com.example.presentation.route

import com.example.presentation.handler.ExternalApiHandler
import io.ktor.server.routing.*

fun Route.externalApiRoutes(handler: ExternalApiHandler) {
    route("/external") {
        // http://127.0.0.1:8081/external/geocoding?q=渋谷駅
        get("/geocoding") {
            handler.geocoding(call)
        }
        // http://127.0.0.1:8081/external/weather?lat=35.6895&lon=139.6917
        get("/weather") {
            handler.getWeather(call)
        }
    }
}
