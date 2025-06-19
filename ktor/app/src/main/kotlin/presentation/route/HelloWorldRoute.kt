package com.example.presentation.route

import com.example.presentation.handler.HelloWorldHandler
import io.ktor.server.routing.*

fun Route.helloWorldRoutes(handler: HelloWorldHandler) {
    route("/") {
        // http://127.0.0.1:8081/
        get {
            handler.helloWorld(call)
        }
    }
}