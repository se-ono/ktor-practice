package com.example.application.usecase

import com.example.domain.repository.UserRepository
import kotlinx.serialization.Serializable

@Serializable
data class SaveUserRequest(
    val name: String
)

class SaveUserUseCase(private val userRepository: UserRepository)
{
    fun execute(saveUserRequest: SaveUserRequest) {
        userRepository.save(saveUserRequest.name)
    }
}