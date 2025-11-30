package com.example.blackmouth.Screens

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackmouth.Screens.Components.Header
import com.example.blackmouth.Screens.Components.LoginButton
import com.example.blackmouth.Screens.Components.TextFieldEmail
import com.example.blackmouth.Screens.Components.TextFieldPassword
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun LoginScreen(){
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
                text = "Bienvenido a BlackMouth",
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                lineHeight = 45.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Por favor inicie sesion.",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            TextFieldEmail("Email")
            TextFieldPassword("Contraseña")

            LoginButton("Iniciar Sesión")

            Text("No tienes cuenta? Registrate",
                modifier = Modifier
                    .padding(top = 50.dp)
                    .clickable{
                    }
            )
        }
    }
}

@Composable
@Preview
fun LoginScreenView(){
    BlackMouthTheme {
        LoginScreen()
    }
}

