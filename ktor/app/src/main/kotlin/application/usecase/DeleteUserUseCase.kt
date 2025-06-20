package com.example.application.usecase

import com.example.domain.repository.UserRepository
import kotlinx.serialization.Serializable


@Serializable
data class DeleteUserRequest(
    val id: Long
)

class DeleteUserUseCase (private val userRepository: UserRepository) {
    fun execute(deleteUserRequest: DeleteUserRequest) {
        userRepository.delete(deleteUserRequest.id)
    }
}