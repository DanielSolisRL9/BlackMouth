package com.example.blackmouth.domain.models

import com.google.gson.annotations.SerializedName

data class MenuItem(
    val id: String? = null,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    @SerializedName("imageURL")
    val imageURL: String
)