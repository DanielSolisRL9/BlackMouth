package com.example.blackmouth.data.services


import com.example.blackmouth.domain.dtos.CreateOrderDTO
import com.example.blackmouth.domain.models.Order
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface OrderService {

    @GET("orders/{userID}")
    suspend fun getOrdersByUser(
        @Path("userID") userId: String
    ): List<Order>

    @POST("orders")
    suspend fun createOrder(
        @Body createOrderDTO: CreateOrderDTO
    ): Order
}