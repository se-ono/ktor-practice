package com.example.application.usecase

import com.example.application.request.SaveUserRequest
import com.example.domain.repository.UserRepository

class SaveUserUseCase(private val userRepository: UserRepository)
{
    fun execute(saveUserRequest: SaveUserRequest) {
        userRepository.save(saveUserRequest.name)
    }
}