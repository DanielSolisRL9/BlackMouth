package com.example.blackmouth.ui.Screens.HomeScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun CardFavoriteFood() {
    Column (
        modifier = Modifier
            .height(140.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.3.dp, Color.Black, RoundedCornerShape(10.dp))
            .background(Color.White)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .background(Color.Gray)
        ){
            AsyncImage(
                model = "",
                contentDescription = null
                //agregar la propiedad para que la imagen cubra toda la zona gris
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 3.dp),
            verticalArrangement = Arrangement.spacedBy(-7.dp)
        ){
            Text(
                text = "Nombre",
                fontSize = 13.sp
            )
            Text(
                text = "Costo",
                fontSize = 10.sp,
                color = Color.DarkGray
            )
            Text(
                text = "Tiempo de entrega",
                fontSize = 10.sp,
                color = Color.DarkGray
            )
        }

    }
}

@Preview
@Composable
fun CardFavoriteFoodView(){
    BlackMouthTheme {
        CardFavoriteFood()
    }
}