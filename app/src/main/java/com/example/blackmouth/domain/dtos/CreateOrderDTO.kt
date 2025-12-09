package com.example.blackmouth.domain.dtos

import java.util.UUID

data class CreateOrderDTO(
    val userID: UUID,
    val items: List<OrderItemDTO>
)

data class OrderItemDTO(
    val menuItemID: UUID,
    val quantity: Int
)