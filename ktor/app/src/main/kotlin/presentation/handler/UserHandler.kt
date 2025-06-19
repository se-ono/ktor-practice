package com.example.presentation.handler

import com.example.presentation.controller.GetUserController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

class UserHandler(private val controller: GetUserController) {
    suspend fun getUser(call: ApplicationCall) {
        val id = call.parameters["id"]?.toLongOrNull()
        if (id == null) {
            call.respond(HttpStatusCode.BadRequest, "Invalid ID")
            return
        }

        val user = controller.getUser(id)
        if (user == null) {
            call.respond(mapOf<String, Any>())
        } else {
            call.respond(user)
        }
    }
}
