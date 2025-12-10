package com.example.blackmouth.ui.Screens.UserScreen.UserComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackmouth.ui.theme.BlackMouthTheme

@Composable
fun OptionList(icon : ImageVector,description : String){
    Row (modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
        )
        Spacer(
            modifier = Modifier
                .width(10.dp))
        Text(text = description, fontWeight = FontWeight.Bold, fontSize = 17.sp)
    }
}

@Preview
@Composable
fun OptionListView()
{
    BlackMouthTheme {
        OptionList(Icons.Default.FavoriteBorder,"Favoritos")
    }
}