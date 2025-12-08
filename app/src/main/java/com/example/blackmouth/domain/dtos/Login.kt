package com.example.blackmouth.domain.dtos

import kotlinx.serialization.Serializable

@Serializable
data class Login (
    val email: String,
    val password: String
)

