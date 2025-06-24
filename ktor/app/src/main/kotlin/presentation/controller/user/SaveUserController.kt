package com.example.presentation.controller.user

import com.example.application.request.user.SaveUserRequest
import com.example.application.usecase.user.SaveUserUseCase

class SaveUserController(private val saveUserUseCase: SaveUserUseCase) {
    fun saveUser(saveUserRequest: SaveUserRequest) {
        return saveUserUseCase.execute(saveUserRequest)
    }
}