package com.example.blackmouth.ui.Screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blackmouth.ui.Screens.HomeScreen.Components.CardFavoriteFood
import com.example.blackmouth.ui.Screens.HomeScreen.Components.FavoriteFoodGrid
import com.example.blackmouth.ui.Screens.HomeScreen.Components.Header
import com.example.blackmouth.ui.Screens.HomeScreen.Components.LazyRowFood
import com.example.blackmouth.ui.Screens.HomeScreen.Components.OutLinedTextField
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController
){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp)
    ){
        item {
            Header()
        }
        item {
            OutLinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = Icons.Default.Search,
                placeholder = "¿Qué quieres hoy?"
            )
        }

        item {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }

        item {
            LazyRowFood()
        }

        item {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }

        item{
            Text(
                text = "Vuelve a pedir tus favoritos del mes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }

        item {
            FavoriteFoodGrid()
        }

        item {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }

        item{
            Text(
                text = "Lo mas vendido",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        
        item {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(5){
                    CardFavoriteFood()
                    //cambiar esto cuando ya este conectada a la api
                }
            }
        }

        item {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }

        item{
            Text(
                text = "Descubre ago nuevo",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(5){
                    CardFavoriteFood()
                    //cambiar esto cuando ya este conectada a la api
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