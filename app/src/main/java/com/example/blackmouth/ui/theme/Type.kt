package com.example.blackmouth.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.blackmouth.R
val lemonMilkFontFamily = FontFamily(
    Font(R.font.lemonmilklight, FontWeight.Light),
    Font(R.font.lemonmilkregular, FontWeight.Normal),
    Font(R.font.lemonmilkbold, FontWeight.Bold)
)
val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = lemonMilkFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = lemonMilkFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),

    labelSmall = TextStyle(
        fontFamily = lemonMilkFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
