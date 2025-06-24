package com.example.application.usecase.user

import com.example.domain.model.User
import com.example.domain.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository)
{
    fun execute(id: Long): User? {
        return userRepository.findById(id)
    }
}