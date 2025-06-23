package com.example.application.usecase

import com.example.application.request.UpdateUserRequest
import com.example.domain.repository.UserRepository

class UpdateUserUseCase(private val userRepository: UserRepository) {
    fun execute(updateUserRequest: UpdateUserRequest) {
        userRepository.update(updateUserRequest.id, updateUserRequest.name)
    }
}