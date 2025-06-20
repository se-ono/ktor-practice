package com.example.presentation.handler

import com.example.application.usecase.DeleteUserRequest
import com.example.application.usecase.SaveUserRequest
import com.example.application.usecase.UpdateUserRequest
import com.example.presentation.controller.DeleteUserController
import com.example.presentation.controller.GetUserController
import com.example.presentation.controller.SaveUserController
import com.example.presentation.controller.UpdateUserController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

class UserHandler(
    private val getUserController: GetUserController,
    private val saveUserController: SaveUserController,
    private val updateUserController: UpdateUserController,
    private val deleteUserController: DeleteUserController,
) {
    suspend fun getUser(call: ApplicationCall) {
        val id = call.parameters["id"]?.toLongOrNull()
        if (id == null) {
            call.respond(HttpStatusCode.BadRequest, "Invalid ID")
            return
        }

        val user = getUserController.getUser(id)
        if (user == null) {
            call.respond(HttpStatusCode.OK, mapOf<String, Any>())
        } else {
            call.respond(HttpStatusCode.OK, user)
        }
    }

    suspend fun saveUser(call: ApplicationCall) {
        val request = call.receive<SaveUserRequest>()
        if (request.name.isBlank()) {
            call.respond(HttpStatusCode.BadRequest, "Invalid name")
            return
        }

        saveUserController.saveUser(request)
        call.respond(HttpStatusCode.OK)
    }

    suspend fun updateUser(call: ApplicationCall) {
        val request = call.receive<UpdateUserRequest>()
        if (request.name.isBlank()) {
            call.respond(HttpStatusCode.BadRequest, "Invalid name")
            return
        }

        updateUserController.updateUser(request)
        call.respond(HttpStatusCode.OK)
    }

    suspend fun deleteUser(call: ApplicationCall) {
        val request = call.receive<DeleteUserRequest>()

        deleteUserController.deleteUser(request)
        call.respond(HttpStatusCode.OK)
    }
}
