package com.example.presentation.controller

import com.example.application.request.UpdateUserRequest
import com.example.application.usecase.UpdateUserUseCase

class UpdateUserController(private val updateUserUseCase: UpdateUserUseCase) {
    fun updateUser(updateUserRequest: UpdateUserRequest) {
        return updateUserUseCase.execute(updateUserRequest)
    }
}
