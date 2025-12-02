package com.example.blackmouth.ui.Screens.HomeScreen.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LazyRowFood(){
    val tags = listOf(
        "🍔 Hamburguesas",
        "🍕 Pizzas",
        "🍟 Papas",
        "👂🏿 Gourmet",
        "🥗 Ensalada",
        "🥪 Sandwich",
        "🍰 Postres",
        "🧋 Bebidas"
    )

    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(tags){ tag ->
            Text(
                text = tag,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(1.dp, Color.Black, shape = CircleShape)
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .clickable{

                    },
                fontWeight = FontWeight.Bold
            )
        }

    }
}