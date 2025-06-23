package com.example.application.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserRequest(
    val id: Long,
    val name: String,
)