package com.example

import com.example.infrastructure.database.configureDatabase
import com.example.infrastructure.env.EnvLoader
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main(args: Array<String>) {
    EnvLoader().loadEnv(".env").forEach { (key, value) ->
        System.setProperty(key, value)
    }

    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }

    configureDatabase()
    configureRouting()
}
