package com.example.application.di

import com.example.application.usecase.*
import com.example.application.usecase.externalApi.GeocodingUseCase
import com.example.application.usecase.externalApi.WeatherUseCase
import com.example.application.usecase.helloWorld.HelloWorldUseCase
import com.example.application.usecase.user.DeleteUserUseCase
import com.example.application.usecase.user.GetUserUseCase
import com.example.application.usecase.user.GetUsersUseCase
import com.example.application.usecase.user.SaveUserUseCase
import com.example.application.usecase.user.UpdateUserUseCase
import com.example.domain.repository.UserRepository
import com.example.infrastructure.api.ExternalHttpClient
import com.example.infrastructure.api.GeocodingApiClient
import com.example.infrastructure.api.WeatherApiClient
import com.example.presentation.controller.*
import com.example.presentation.controller.externaiApi.GeocodingController
import com.example.presentation.controller.externaiApi.WeatherController
import com.example.presentation.controller.helloWorld.HelloWorldController
import com.example.presentation.controller.user.DeleteUserController
import com.example.presentation.controller.user.GetUserController
import com.example.presentation.controller.user.GetUsersController
import com.example.presentation.controller.user.SaveUserController
import com.example.presentation.controller.user.UpdateUserController
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

    single { GetUsersUseCase(get()) }
    single { GetUsersController(get()) }
    single { GetUserUseCase(get()) }
    single { GetUserController(get()) }
    single { SaveUserUseCase(get()) }
    single { SaveUserController(get()) }
    single { UpdateUserUseCase(get()) }
    single { UpdateUserController(get()) }
    single { DeleteUserUseCase(get()) }
    single { DeleteUserController(get()) }
    single { UserHandler(get(), get(), get(), get(), get()) }
}
