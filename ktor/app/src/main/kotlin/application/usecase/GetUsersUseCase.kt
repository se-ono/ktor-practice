package com.example.application.usecase

import com.example.domain.model.User
import com.example.domain.repository.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository)
{
    fun execute(): List<User> {
        return userRepository.getAll()
    }
}