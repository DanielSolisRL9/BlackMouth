package com.example.blackmouth.ui.Screens.Order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blackmouth.domain.models.MenuItem
import com.example.blackmouth.ui.Screens.Order.orderComponents.BotonContinue
import com.example.blackmouth.ui.Screens.Order.orderComponents.OrderHeader
import com.example.blackmouth.ui.Screens.Order.orderComponents.OrderViewCard
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun orderScreen(

    paddingValues: PaddingValues,
    navController: NavController

){
    val sampleItem = MenuItem(
        id = "1",
        name = "Hamburguesa",
        description = "Deliciosa hamburguesa con queso, lechuga y tomate.",
        price = 8.99,
        category = "Comida",
        imageURL = "https://via.placeholder.com/150"
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
            .padding(15.dp)
    ) {
            OrderHeader(navController)

            Spacer(modifier = Modifier.height(10.dp))
        LazyColumn( ) {
           item {   OrderViewCard(menuItem = sampleItem) //Hasta ahora se enseña sampleitem
            }
        }
        Spacer(modifier = Modifier.height(500.dp))
            BotonContinue()
    }
}


