package com.example.blackmouth.domain.dtos

import com.example.blackmouth.domain.models.Order
import java.util.UUID

data class CreateOrderDTO(
    val user_id: UUID,
    val items: List<Order>,
    val status: String = "cart"
)
