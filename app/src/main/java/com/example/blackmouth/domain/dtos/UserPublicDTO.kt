package com.example.blackmouth.domain.dtos

import kotlinx.serialization.Serializable

@Serializable
data class UserPublicDTO(
    val id: String?,
    val username: String,
    val email: String
)
