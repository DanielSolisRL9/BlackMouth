package com.example.blackmouth.data.services

import com.example.blackmouth.domain.dtos.AuthResponse
import com.example.blackmouth.domain.dtos.LoginDTO
import com.example.blackmouth.domain.dtos.UserDTO;
import com.example.blackmouth.domain.dtos.UserPublicDTO
import com.example.blackmouth.domain.models.User
import kotlin.Unit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Response;

interface AuthService {

    @POST("users/register")
    suspend fun register(@Body userDTO: UserDTO): Response<UserPublicDTO>

    @POST("users/login")
    suspend fun login(@Body loginDTO: LoginDTO): Response<UserPublicDTO>
}
