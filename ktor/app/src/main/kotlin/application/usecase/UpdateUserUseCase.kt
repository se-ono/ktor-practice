package com.example.application.usecase

import com.example.domain.repository.UserRepository
import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserRequest(
    val id: Long,
    val name: String
)

class UpdateUserUseCase(private val userRepository: UserRepository) {
    fun execute(updateUserRequest: UpdateUserRequest) {
        userRepository.update(updateUserRequest.id, updateUserRequest.name)
    }
}