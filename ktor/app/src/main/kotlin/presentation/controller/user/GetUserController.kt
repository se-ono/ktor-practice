package com.example.presentation.controller.user

import com.example.application.usecase.user.GetUserUseCase
import com.example.domain.model.User

class GetUserController(private val getUserUseCase: GetUserUseCase) {
    fun getUser(id: Long): User? {
        return getUserUseCase.execute(id)
    }
}