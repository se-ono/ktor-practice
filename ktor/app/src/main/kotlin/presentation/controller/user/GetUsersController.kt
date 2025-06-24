package com.example.presentation.controller.user

import com.example.application.usecase.user.GetUsersUseCase
import com.example.domain.model.User

class GetUsersController(private val getUsersUseCase: GetUsersUseCase) {
    fun getUsers(): List<User> {
        return getUsersUseCase.execute()
    }
}