package com.example.infrastructure.database

import io.ktor.server.application.*

fun Application.configureDatabase() {
    connectDatabase()
}
