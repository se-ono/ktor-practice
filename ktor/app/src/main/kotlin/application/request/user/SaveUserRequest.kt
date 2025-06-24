package com.example.application.request.user

import kotlinx.serialization.Serializable

@Serializable
data class SaveUserRequest(
    val name: String,
)