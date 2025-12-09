package com.example.blackmouth.domain.models

data class MenuItem (
    val id: String? = null,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    val imageURL: String
)