package com.example.blackmouth.ui.Screens.HomeScreen.Components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun Header(/*poner el logout*/){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Row (
            modifier = Modifier
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Avenida Universidad 606",
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
        }

        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
        }

        IconButton(
            onClick = {}//poner el logout
        ) {
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
        }



    }
}

@Preview
@Composable
fun HeaderView(){
    BlackMouthTheme {
        Header()
    }
}