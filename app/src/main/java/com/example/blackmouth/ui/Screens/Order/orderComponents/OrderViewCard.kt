package com.example.blackmouth.ui.Screens.Order.orderComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.blackmouth.domain.models.MenuItem
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun OrderViewCard(
    menuItem : MenuItem
    ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(contentColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment =Alignment.CenterVertically
        ) {
            AsyncImage(
                model = menuItem.imageURL ?: "",
                contentDescription = menuItem.name ?: "",
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = menuItem.name ?: "",
                    color = Color.Black
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Cantidad:",
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Precio: $${menuItem.price ?: "0.00"}",
                        color = Color.DarkGray
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = menuItem.description,
                        color = Color.Gray,
                        maxLines = 2
                    )
                }

            }
        }

    }
}

@Preview
@Composable
fun OrderViewCardPreview() {
    val sampleMenuItem = MenuItem(
        id = "1",
        name = "Hamburguesa",
        description = "Deliciosa hamburguesa con queso, lechuga y tomate.",
        price = 8.99,
        category = "Comida",
        imageURL = "https://via.placeholder.com/150"
    )
    BlackMouthTheme {

        OrderViewCard(menuItem = sampleMenuItem)
    }
}

