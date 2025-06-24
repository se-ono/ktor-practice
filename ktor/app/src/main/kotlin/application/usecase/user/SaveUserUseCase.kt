package com.example.application.usecase.user

import com.example.application.request.user.SaveUserRequest
import com.example.domain.repository.UserRepository

class SaveUserUseCase(private val userRepository: UserRepository)
{
    fun execute(saveUserRequest: SaveUserRequest) {
        userRepository.save(saveUserRequest.name)
    }
}