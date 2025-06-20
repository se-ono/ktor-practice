package com.example.presentation.route

import com.example.presentation.handler.UserHandler
import io.ktor.server.routing.*

fun Route.userRoutes(handler: UserHandler) {
    route("/users") {
        // http://127.0.0.1:8081/users/1
        get("{id}") {
            handler.getUser(call)
        }
        // http://127.0.0.1:8081/users
        post("") {
            handler.saveUser(call)
        }
        // http://127.0.0.1:8081/users/update
        put("/update") {
            handler.updateUser(call)
        }
    }
}