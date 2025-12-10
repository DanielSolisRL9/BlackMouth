package com.example.blackmouth.ui.Screens.MenuDetail.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun MenuItemDetail(
    item: MenuItemDTO?,
    onAddToCart: () -> Unit,
    onClose: () -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Imagen
        AsyncImage(
            model = item?.imageUrl,
            contentDescription = item?.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(colors.primary.copy(alpha = 0.1f)),
            contentScale = ContentScale.Crop
        )

        // Nombre
        Text(
            text = item?.name ?: "",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 12.dp)
        )

        // Precio y categoría
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(40))
                .background(colors.primary.copy(alpha = 0.15f))
                .padding(horizontal = 14.dp, vertical = 10.dp)
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.AttachMoney, null, tint = colors.primary)
            Spacer(Modifier.width(4.dp))
            Text("${item?.price}", fontWeight = FontWeight.Bold, color = colors.primary)

            Spacer(Modifier.width(12.dp))

            Icon(Icons.Default.LocalDining, null, tint = colors.primary)
            Spacer(Modifier.width(4.dp))
            Text(item?.category ?: "", color = colors.primary, fontWeight = FontWeight.SemiBold)
        }

        // Descripción
        Text(
            text = "Descripción",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = item?.description ?: "",
            modifier = Modifier.padding(top = 4.dp)
        )

        // Botones
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = onClose) {
                Text("Cerrar")
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(onClick = onAddToCart) {
                Text("Agregar al pedido")
            }
        }
    }
}

data class MenuItemDTO(
    val name: String,
    val category: String,
    val price: Double,
    val imageUrl: String,
    val description: String
)

@Preview(showBackground = true)
@Composable
fun MenuDetailPreview() {
    BlackMouthTheme {
        MenuItemDetail(
            item = MenuItemDTO(
                name = "Hamburguesa BBQ",
                category = "Americana",
                price = 159.99,
                imageUrl = "https://images.unsplash.com/photo-1550547660-d9450f859349",
                description = "Una deliciosa hamburguesa con carne angus, salsa BBQ casera, queso derretido y aros de cebolla crujientes."
            ),
            onAddToCart = {},
            onClose = {}
        )
    }
}
