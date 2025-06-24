package com.example.presentation.controller.user

import com.example.application.request.user.DeleteUserRequest
import com.example.application.usecase.user.DeleteUserUseCase

class DeleteUserController (private val deleteUserUseCase: DeleteUserUseCase) {
    fun deleteUser(deleteUserRequest: DeleteUserRequest) {
        return deleteUserUseCase.execute(deleteUserRequest)
    }
}