package com.example

import com.example.application.di.appModule
import com.example.presentation.handler.ExternalApiHandler
import com.example.presentation.handler.HelloWorldHandler
import com.example.presentation.handler.UserHandler
import com.example.presentation.route.externalApiRoutes
import com.example.presentation.route.helloWorldRoutes
import com.example.presentation.route.userRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureRouting() {
    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }

    val helloWorldHandler by inject<HelloWorldHandler>()
    val userHandler by inject<UserHandler>()
    val externalApiHandler by inject<ExternalApiHandler>()

    routing {
        helloWorldRoutes(helloWorldHandler)
        userRoutes(userHandler)
        externalApiRoutes(externalApiHandler)
    }
}
