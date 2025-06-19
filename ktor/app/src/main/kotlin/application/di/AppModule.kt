package com.example.application.di

import com.example.application.usecase.GeocodingUseCase
import com.example.application.usecase.GetUserUseCase
import com.example.application.usecase.HelloWorldUseCase
import com.example.application.usecase.WeatherUseCase
import com.example.domain.repository.UserRepository
import com.example.infrastructure.api.ExternalHttpClient
import com.example.infrastructure.api.GeocodingApiClient
import com.example.infrastructure.api.WeatherApiClient
import com.example.presentation.controller.GeocodingController
import com.example.presentation.controller.GetUserController
import com.example.presentation.controller.HelloWorldController
import com.example.presentation.controller.WeatherController
import com.example.presentation.handler.ExternalApiHandler
import com.example.presentation.handler.HelloWorldHandler
import com.example.presentation.handler.UserHandler
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val appModule = module {

    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }

    single { ExternalHttpClient(get()) }
    single { GeocodingApiClient(get()) }
    single { WeatherApiClient(get()) }

    single { UserRepository() }

    single { HelloWorldUseCase() }
    single { GetUserUseCase(get()) }
    single { GeocodingUseCase(get()) }
    single { WeatherUseCase(get()) }

    single { HelloWorldController(get()) }
    single { GetUserController(get()) }
    single { GeocodingController(get()) }
    single { WeatherController(get()) }

    single { HelloWorldHandler(get()) }
    single { UserHandler(get()) }
    single { ExternalApiHandler(get(), get()) }
}
