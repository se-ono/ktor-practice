package com.example.presentation.controller

import com.example.application.usecase.GetUsersUseCase
import com.example.domain.model.User

class GetUsersController(private val getUsersUseCase: GetUsersUseCase) {
    fun getUsers(): List<User> {
        return getUsersUseCase.execute()
    }
}
