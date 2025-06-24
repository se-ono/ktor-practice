package com.example.presentation.controller.user

import com.example.application.request.user.UpdateUserRequest
import com.example.application.usecase.user.UpdateUserUseCase

class UpdateUserController(private val updateUserUseCase: UpdateUserUseCase) {
    fun updateUser(updateUserRequest: UpdateUserRequest) {
        return updateUserUseCase.execute(updateUserRequest)
    }
}