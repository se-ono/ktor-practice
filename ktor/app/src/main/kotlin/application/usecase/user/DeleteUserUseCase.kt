package com.example.application.usecase.user

import com.example.application.request.user.DeleteUserRequest
import com.example.domain.repository.UserRepository

class DeleteUserUseCase (private val userRepository: UserRepository) {
    fun execute(deleteUserRequest: DeleteUserRequest) {
        userRepository.delete(deleteUserRequest.id)
    }
}