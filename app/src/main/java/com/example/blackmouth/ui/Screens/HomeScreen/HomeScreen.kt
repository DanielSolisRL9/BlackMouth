package com.example.blackmouth.ui.Screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blackmouth.ui.Screens.HomeScreen.Components.CardFavoriteFood
import com.example.blackmouth.ui.Screens.HomeScreen.Components.FavoriteFoodGrid
import com.example.blackmouth.ui.Screens.HomeScreen.Components.Header
import com.example.blackmouth.ui.Screens.HomeScreen.Components.LazyRowFood
import com.example.blackmouth.ui.Screens.HomeScreen.Components.OutLinedTextField
import com.example.blackmouth.ui.viewModels.MenuViewModel

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: MenuViewModel
) {
    // 🚀 Colectar StateFlow correctamente
    val menuItems by viewModel.menuItems.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    // 👉 SOLO SE EJECUTA LA PRIMERA VEZ (gracias a remember)
    val hasLoaded = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        println("MENÚ RECIBIDO: $menuItems")
        if (!hasLoaded.value) {

            viewModel.loadMenu()
            hasLoaded.value = true
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
            .padding(horizontal = 15.dp)
    ) {

        // HEADER
        item { Header() }

        item {
            OutLinedTextField(
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = Icons.Default.Search,
                placeholder = "¿Qué quieres hoy?"
            )
        }

        item { Spacer(modifier = Modifier.height(10.dp)) }

        item { LazyRowFood() }

        item { Spacer(modifier = Modifier.height(10.dp)) }

        //-----------------------------------------
        // Favoritos del mes
        //-----------------------------------------
        item {
            Text(
                text = "Vuelve a pedir tus favoritos del mes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item { Spacer(modifier = Modifier.height(10.dp)) }

        item {
            FavoriteFoodGrid(items = menuItems)
        }

        item { Spacer(modifier = Modifier.height(10.dp)) }

        //-----------------------------------------
        // Lo Más Vendido
        //-----------------------------------------
        item {
            Text(
                text = "Lo más vendido",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item { Spacer(modifier = Modifier.height(10.dp)) }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(menuItems) { item ->
                    CardFavoriteFood(item = item)
                }
            }
        }

        item { Spacer(modifier = Modifier.height(10.dp)) }

        //-----------------------------------------
        // Descubre algo nuevo
        //-----------------------------------------
        item {
            Text(
                text = "Descubre algo nuevo",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item { Spacer(modifier = Modifier.height(10.dp)) }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(menuItems) { item ->
                    CardFavoriteFood(item = item)
                }
            }
        }
    }
}

//@Composable
//@Preview
//fun HomeScreenView(){
//    BlackMouthTheme {
//        HomeScreen(
//
//        )
//    }
//}