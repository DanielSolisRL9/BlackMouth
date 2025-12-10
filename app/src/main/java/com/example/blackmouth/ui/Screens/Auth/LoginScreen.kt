package com.example.blackmouth.ui.Screens.Auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.blackmouth.ui.Components.Animacion
import com.example.blackmouth.ui.Screens.Auth.Components.Header
import com.example.blackmouth.ui.Screens.Auth.Components.LoginButton
import com.example.blackmouth.ui.Screens.Auth.Components.TextFieldEmail
import com.example.blackmouth.ui.Screens.Auth.Components.TextFieldPassword
import com.example.blackmouth.ui.Screens.HomeScreenRoute
import com.example.blackmouth.ui.Screens.LoginScreenRoute
import com.example.blackmouth.ui.Screens.RegisterScreenRoute
import com.example.blackmouth.ui.viewModels.AuthViewModel

@Composable
fun LoginScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: AuthViewModel
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Header()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Bienvenido\nBlackMouth",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 32.sp
            )

            Text(
                text = "Por favor inicie sesión.",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            TextFieldEmail(
                entry = "Email",
                icon = Icons.Default.Email,
                value = email,
                onValueChange = { email = it }
            )

            TextFieldPassword(
                entry = "Contraseña",
                value = password,
                onValueChange = { password = it }
            )

            LoginButton("Iniciar Sesión") {
                viewModel.login(email, password) { result, message ->
                    if (result) {
                        navController.navigate(HomeScreenRoute) {
                            popUpTo(LoginScreenRoute) { inclusive = true }
                        }
                    } else {
                        println(message)
                    }
                }
            }

            Text(
                text = "¿No tienes cuenta? Regístrate",
                modifier = Modifier
                    .padding(top = 40.dp)
                    .clickable {
                        navController.navigate(RegisterScreenRoute)
                    }
            )
        }
    }
    if (viewModel.isLoading){
        Animacion("Iniciar Sesión")
    }
}
