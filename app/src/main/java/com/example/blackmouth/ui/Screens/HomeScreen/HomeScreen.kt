package com.example.blackmouth.ui.Screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blackmouth.domain.models.MenuItem
import com.example.blackmouth.ui.Screens.HomeScreen.Components.*
import com.example.blackmouth.ui.Screens.HomeScreenRoute
import com.example.blackmouth.ui.Screens.LoginScreenRoute
import com.example.blackmouth.ui.Screens.MenuDetail.Components.MenuItemDTO
import com.example.blackmouth.ui.Screens.MenuDetail.Components.MenuItemDetail
import com.example.blackmouth.ui.viewModels.MenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: MenuViewModel
) {
    val menuItems by viewModel.menuItems.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val hasLoaded = remember { mutableStateOf(false) }

    val selectedItem by viewModel.selectedItem.collectAsState()
    val showSheet by viewModel.showSheet.collectAsState()

    // Cargar menú al iniciar
    LaunchedEffect(Unit) {
        if (!hasLoaded.value) {
            viewModel.loadMenu()
            hasLoaded.value = true
        }
    }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    LaunchedEffect(showSheet) {
        if (showSheet) sheetState.show() else sheetState.hide()
    }

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(horizontal = 15.dp)
        ) {
            item { Header(
                onLogout = {
                    navController.navigate(LoginScreenRoute){
                        popUpTo(HomeScreenRoute){
                            inclusive = true
                        }
                    }
                }
            ) }

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

            item {
                Text(
                    text = "Vuelve a pedir tus favoritos del mes",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item { Spacer(modifier = Modifier.height(10.dp)) }

            item {
                FavoriteFoodGrid(items = menuItems) { item ->
                    viewModel.selectItem(item)
                }
            }

            item { Spacer(modifier = Modifier.height(10.dp)) }

            // Lo más vendido
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
                        CardFavoriteFood(item) {
                            viewModel.selectItem(item)
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(10.dp)) }

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
                        CardFavoriteFood(item) {
                            viewModel.selectItem(item)
                        }
                    }
                }
            }

            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        contentAlignment = Alignment.Center
                    ) { CircularProgressIndicator() }
                }
            }

            // Error
            if (!errorMessage.isNullOrEmpty()) {
                item {
                    Text(
                        text = "Error: $errorMessage",
                        color = Color.Red,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        if (selectedItem != null) {
            ModalBottomSheet(
                onDismissRequest = { viewModel.closeSheet() },
                sheetState = sheetState,
                dragHandle = { BottomSheetDefaults.DragHandle() }
            ) {
                MenuItemDetail(
                    item = MenuItemDTO(
                        name = selectedItem!!.name,
                        category = selectedItem!!.category,
                        price = selectedItem!!.price,
                        imageUrl = selectedItem!!.imageURL,
                        description = selectedItem!!.description
                    ),
                    onAddToCart = { /* acción carrito */ },
                    onClose = { viewModel.closeSheet() }
                )
            }
        }
    }
}