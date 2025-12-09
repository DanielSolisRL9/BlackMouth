package com.example.blackmouth.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.blackmouth.data.services.AuthService
import com.example.blackmouth.data.services.MenuService
import com.example.blackmouth.data.services.OrderService

object RetrofitClient {
    val base_url = "http://143.198.48.101:8080/"

    val retrofit = Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun createAuthService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    fun createMenuService(): MenuService {
        return retrofit.create(MenuService::class.java)
    }

    fun createOrderService(): OrderService {
        return retrofit.create(OrderService::class.java)
    }
}