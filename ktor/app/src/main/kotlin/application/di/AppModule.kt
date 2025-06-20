package com.example.application.di

import com.example.application.usecase.*
import com.example.domain.repository.UserRepository
import com.example.infrastructure.api.ExternalHttpClient
import com.example.infrastructure.api.GeocodingApiClient
import com.example.infrastructure.api.WeatherApiClient
import com.example.presentation.controller.*
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

    single { HelloWorldUseCase() }
    single { HelloWorldController(get()) }
    single { HelloWorldHandler(get()) }

    single { ExternalHttpClient(get()) }
    single { GeocodingApiClient(get()) }
    single { GeocodingUseCase(get()) }
    single { GeocodingController(get()) }
    single { WeatherApiClient(get()) }
    single { WeatherUseCase(get()) }
    single { WeatherController(get()) }
    single { ExternalApiHandler(get(), get()) }

    single { UserRepository() }

    single { GetUserUseCase(get()) }
    single { GetUserController(get()) }
    single { SaveUserUseCase(get()) }
    single { SaveUserController(get()) }
    single { UpdateUserUseCase(get()) }
    single { UpdateUserController(get()) }
    single { DeleteUserUseCase(get()) }
    single { DeleteUserController(get()) }
    single { UserHandler(get(), get(), get(), get()) }
}
