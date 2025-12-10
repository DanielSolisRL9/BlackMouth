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
    // Lista de pedidos de ejemplo
    val sampleItems = listOf(
        MenuItem(
            id = "1",
            name = "bbq beacon burger",
            description = "Hamburguesa con carne angus, bacon, queso cheddar, salsa bbq y pan brioche.",
            price = 8.99,
            category = "Comida",
            imageURL = "https://highestcreations.com/wp-content/uploads/2023/08/BBQ_Bacon_Burger_With_Caramelized_Onions_fi-scaled.jpg"
        ),
        MenuItem(
            id = "2",
            name = "Pizza",
            description = "Pizza con pepperoni y extra queso.",
            price = 12.50,
            category = "Comida",
            imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTI0-HmskFIOzX-o3_DTZdgLshMNluWvZpwAw&s"
        ),
        MenuItem(
            id = "3",
            name = "Milkshake vainilla",
            description = "milkshake cremoso de vainilla con topping de crema batida y cereza.",
            price = 7.25,
            category = "Comida",
            imageURL = "https://comedera.com/wp-content/uploads/sites/9/2022/10/Merengada-de-vainilla-con-chocolatePG_BDVCSD180520002.jpg"
        ),
        MenuItem(
            id = "4",
            name = "Papas blackmouth",
            description = "Papas crujientes con queso derretido y aderezo especial de la casa.",
            price = 3.50,
            category = "Comida",
            imageURL = "https://hamburguesasgarfields.com/wp-content/uploads/2018/01/French-Fries-french-fries-1-1-862x582.jpg"
        )
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

        LazyColumn {
            items(sampleItems.size) { index ->
                OrderViewCard(menuItem = sampleItems[index])
                Spacer(modifier = Modifier.height(10.dp)) // separación entre pedidos
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        BotonContinue()
    }
}
