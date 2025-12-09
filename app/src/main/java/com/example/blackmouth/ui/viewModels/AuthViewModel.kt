package com.example.blackmouth.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackmouth.data.RetrofitClient
import com.example.blackmouth.domain.dtos.LoginDTO
import com.example.blackmouth.domain.dtos.UserDTO
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val service = RetrofitClient.createAuthService()

    fun register(
        username: String,
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val body = UserDTO(
                    username = username,
                    email = email,
                    passwordHash = password
                )

                val response = service.register(body)

                if (response.isSuccessful) {
                    onResult(true, "Usuario registrado correctamente")
                } else {
                    onResult(false, "Error al registrar usuario: ${response.code()}")
                }

            } catch (e: Exception) {
                onResult(false, "Error: ${e.message}")
            }
        }
    }

    fun login(
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val body = LoginDTO(email, password)
                val response = service.login(body)

                if (response.isSuccessful) {
                    onResult(true, "Inicio de sesión exitoso")
                } else if (response.code() == 401) {
                    onResult(false, "Credenciales incorrectas")
                } else {
                    onResult(false, "Error inesperado: ${response.code()}")
                }

            } catch (e: Exception) {
                onResult(false, "Error: ${e.message}")
            }
        }
    }
}
