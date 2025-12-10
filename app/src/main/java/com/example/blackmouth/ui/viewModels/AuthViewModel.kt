package com.example.blackmouth.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    var isLoading by mutableStateOf(false)


    fun register(
        name: String,
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                isLoading = true

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
            } finally {
                isLoading = false
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
                isLoading = true

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
            finally {
                isLoading = false
            }
        }
    }
}
