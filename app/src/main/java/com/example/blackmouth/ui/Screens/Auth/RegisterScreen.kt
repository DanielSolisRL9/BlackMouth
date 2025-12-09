package com.example.blackmouth.ui.Screens.Auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blackmouth.ui.Screens.Auth.Components.Header
import com.example.blackmouth.ui.Screens.Auth.Components.LoginButton
import com.example.blackmouth.ui.Screens.Auth.Components.TextFieldEmail
import com.example.blackmouth.ui.Screens.Auth.Components.TextFieldPassword
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun RegisterScreen(
    paddingValues: PaddingValues,
    navController: NavController
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
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
                text = "Crear cuenta",
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                lineHeight = 45.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Por favor ingrese sus datos.",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            TextFieldEmail("Nombre", Icons.Default.AccountCircle)
            TextFieldEmail("Email", Icons.Default.Email)
            TextFieldPassword("Contraseña")
            TextFieldPassword("Confirmar contraseña")

            LoginButton("Registrate")
        }
    }
}
