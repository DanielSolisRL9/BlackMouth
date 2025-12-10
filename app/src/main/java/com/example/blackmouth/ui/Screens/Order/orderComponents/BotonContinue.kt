package com.example.blackmouth.ui.Screens.Order.orderComponents

import android.widget.Button
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonContinue(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {})
            .height(55.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4CAF50),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = "Continuar",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            textAlign = TextAlign.Center
        )
    }
}