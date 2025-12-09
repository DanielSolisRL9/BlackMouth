package com.example.blackmouth.domain.models

import java.util.UUID

data class OrderItem(
    val menuItemID: UUID,
    val quantity: Int
)