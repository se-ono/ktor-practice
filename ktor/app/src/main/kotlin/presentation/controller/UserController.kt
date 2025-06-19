package com.example.presentation.controller

import com.example.application.usecase.GetUserUseCase
import com.example.domain.model.User

class GetUserController(private val getUserUseCase: GetUserUseCase) {
    fun getUser(id: Long): User? {
        return getUserUseCase.execute(id)
    }
}
