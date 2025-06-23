package com.example.application.request

import kotlinx.serialization.Serializable

@Serializable
data class DeleteUserRequest(
    val id: Long,
)