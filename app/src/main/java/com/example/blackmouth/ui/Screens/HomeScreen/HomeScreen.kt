package com.example.blackmouth.ui.Screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blackmouth.ui.Screens.HomeScreen.Components.Header
import com.example.blackmouth.ui.Screens.HomeScreen.Components.OutLinedTextField
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun HomeScreen(){
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
    }
}

@Composable
@Preview
fun HomeScreenView(){
    BlackMouthTheme {
        HomeScreen()
    }
}