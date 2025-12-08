package com.example.blackmouth.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackmouth.data.ktorfitClient
import com.example.blackmouth.domain.dtos.Register
import kotlinx.coroutines.launch

class AuthViewModel {
    class AuthViewModel : ViewModel() {

        fun register(
            name: String,
            email: String,
            password: String,
            onResult: (Boolean, String) -> Unit
        ){
            viewModelScope.launch {
                try{
                    val service = ktorfitClient.createAuthService()
                    val registerBody = Register(name, email, password)

                    val result = service.register(registerBody)

                    if (result.isLogged){
                        onResult(true, result.message)
                    } else {
                        onResult(false, result.message)
                    }
                } catch (e: Exception){
                    onResult(false, "Error al registrarte: ${e.message}")
                }
            }
        }

    }



}