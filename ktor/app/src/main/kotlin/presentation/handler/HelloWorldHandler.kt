package com.example.presentation.handler

import com.example.presentation.controller.HelloWorldController
import io.ktor.server.application.*
import io.ktor.server.response.*

class HelloWorldHandler(private val controller: HelloWorldController) {
    suspend fun helloWorld(call: ApplicationCall) {
        val text = controller.helloWorld()
        call.respondText(text)
    }
}
