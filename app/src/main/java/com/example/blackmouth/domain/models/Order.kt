package com.example.blackmouth.domain.models

import java.util.UUID

data class Order(
    val id: UUID? = null,
    val userID: UUID,
    val items: List<OrderItem>,
    val status: String
)