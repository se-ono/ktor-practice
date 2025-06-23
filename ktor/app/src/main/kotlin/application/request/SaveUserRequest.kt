package com.example.application.request

import kotlinx.serialization.Serializable

@Serializable
data class SaveUserRequest(
    val name: String,
)