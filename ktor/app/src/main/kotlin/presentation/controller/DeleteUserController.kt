package com.example.presentation.controller

import com.example.application.usecase.DeleteUserRequest
import com.example.application.usecase.DeleteUserUseCase

class DeleteUserController (private val deleteUserUseCase: DeleteUserUseCase) {
    fun deleteUser(deleteUserRequest: DeleteUserRequest) {
        return deleteUserUseCase.execute(deleteUserRequest)
    }
}