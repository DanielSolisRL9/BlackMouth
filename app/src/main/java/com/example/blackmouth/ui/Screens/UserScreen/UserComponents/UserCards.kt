package com.example.blackmouth.ui.Screens.UserScreen.UserComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun UserCards(icon : ImageVector,description : String){
    Column(
        modifier = Modifier
            .height(100.dp)
            .width(110.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Text(text = description, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun UserCardsView()
{
    BlackMouthTheme {
        UserCards(Icons.Default.FavoriteBorder,"Favoritos")
    }
}
