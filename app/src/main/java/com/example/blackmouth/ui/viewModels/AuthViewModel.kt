package com.example.blackmouth.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackmouth.data.RetrofitClient
import com.example.blackmouth.domain.dtos.LoginDTO
import com.example.blackmouth.domain.dtos.UserDTO
import com.example.blackmouth.domain.dtos.UserPublicDTO
import kotlinx.coroutines.launch
import retrofit2.Response

class AuthViewModel : ViewModel() {

    private val service = RetrofitClient.createAuthService()

    fun register(
        name: String,
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val body = UserDTO(name, email, password)

                val response: Response<UserPublicDTO> = service.register(body)

                if (response.isSuccessful) {
                    val data = response.body()

                    if (data != null) {
                        onResult(true, "Usuario registrado: ${data.username}")
                    } else {
                        onResult(false, "Error: respuesta vacía del servidor")
                    }

                } else {
                    onResult(false, "Error al registrar: ${response.code()}")
                }

            } catch (e: Exception) {
                onResult(false, "Error: ${e.localizedMessage ?: "Desconocido"}")
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

                val response: Response<UserPublicDTO> = service.login(body)

                if (response.isSuccessful) {
                    val data = response.body()

                    if (data != null) {
                        onResult(true, "Bienvenido, ${data.username}")
                    } else {
                        onResult(false, "Error: respuesta vacía del servidor")
                    }

                } else if (response.code() == 401) {
                    onResult(false, "Credenciales incorrectas")
                } else {
                    onResult(false, "Error inesperado: ${response.code()}")
                }

            } catch (e: Exception) {
                onResult(false, "Error: ${e.localizedMessage ?: "Desconocido"}")
            }
        }
    }
}
