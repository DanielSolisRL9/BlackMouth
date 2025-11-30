package com.example.blackmouth.Screens.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Header(){
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){

        Icon(
            imageVector = Icons.Default.ShoppingCart, //cambiar icono por uno de hamburguesa
            contentDescription = "icono",
            modifier = Modifier.size(90.dp),
            tint = Color.White
        )

    }
}




