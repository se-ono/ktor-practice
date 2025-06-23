package com.example.application.usecase

import com.example.application.request.DeleteUserRequest
import com.example.domain.repository.UserRepository

class DeleteUserUseCase (private val userRepository: UserRepository) {
    fun execute(deleteUserRequest: DeleteUserRequest) {
        userRepository.delete(deleteUserRequest.id)
    }
}