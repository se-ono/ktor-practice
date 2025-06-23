package com.example.presentation.controller

import com.example.application.request.SaveUserRequest
import com.example.application.usecase.SaveUserUseCase

class SaveUserController(private val saveUserUseCase: SaveUserUseCase) {
    fun saveUser(saveUserRequest: SaveUserRequest) {
        return saveUserUseCase.execute(saveUserRequest)
    }
}
