package com.example.blackmouth.ui.Screens.UserScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackmouth.ui.Screens.UserScreen.UserComponents.Header
import com.example.blackmouth.ui.Screens.UserScreen.UserComponents.OptionList
import com.example.blackmouth.ui.Screens.UserScreen.UserComponents.UserCards
import com.example.blackmouth.ui.theme.BlackMouthTheme
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.navigation.NavController


@Composable
fun UserScreen(
    paddingValues: PaddingValues,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
            .padding(start = 15.dp, end = 15.dp, top = 25.dp, bottom = 15.dp)
    ) {
        Header()
        Spacer(modifier = Modifier
            .height(20.dp))
        Row (
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ){
            UserCards(Icons.Default.FavoriteBorder,"Favoritos")
            UserCards(Icons.Default.MailOutline,"Billetera")
            UserCards(Icons.Default.DateRange,"Pedidos")
        }
        Spacer(modifier = Modifier
            .height(30.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item { OptionList(Icons.Default.Menu, "Menú") }
            item { OptionList(Icons.Default.ShoppingCart, "Mi orden") }
            item { OptionList(Icons.Default.Notifications, "Promociones") }
            item { OptionList(Icons.Default.LocationOn, "Ubicación") }
            item { OptionList(Icons.Default.Info, "Horarios") }
            item { OptionList(Icons.Default.Home, "Domicilio") }
            item { OptionList(Icons.Default.Refresh, "Historial de pedidos") }
            item { OptionList(Icons.Default.Person, "Mi cuenta") }
            item { OptionList(Icons.Default.Build, "Ayuda") }
            item { OptionList(Icons.Default.Settings, "Configuración") }
        }

    }
}