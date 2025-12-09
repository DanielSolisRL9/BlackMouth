package com.example.blackmouth.domain.models

data class Order(
    val id: String? = null,
    val user_id: String,
    val items: List<OrderItem>,
    val status: String = "cart"
)