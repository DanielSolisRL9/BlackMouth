package com.example.blackmouth.data.services

import com.example.blackmouth.domain.models.MenuItem
import retrofit2.http.GET;

interface MenuService {

    @GET("menu_items")
    suspend fun getMenuItems(): List<MenuItem>
}