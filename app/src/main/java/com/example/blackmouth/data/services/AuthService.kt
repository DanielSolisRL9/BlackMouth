package com.example.blackmouth.data.services

import com.example.blackmouth.domain.dtos.LoginDTO
import com.example.blackmouth.domain.dtos.UserDTO;
import com.example.blackmouth.domain.models.User
import kotlin.Unit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Response;

interface AuthService {

    @POST("users")
    suspend fun register(
        @Body userDTO: UserDTO
    ): Response<Unit>

    @GET("users")
    suspend fun getUsers(): List<User>

    @POST("login")
    suspend fun login(
        @Body loginDTO: LoginDTO
    ): Response<User>
}
