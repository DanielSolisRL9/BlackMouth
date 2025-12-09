package com.example.blackmouth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.blackmouth.ui.Components.NavBar
import com.example.blackmouth.ui.Screens.AccountScreenRoute
import com.example.blackmouth.ui.Screens.Auth.LoginScreen
import com.example.blackmouth.ui.Screens.Auth.RegisterScreen
import com.example.blackmouth.ui.Screens.HomeScreen.HomeScreen
import com.example.blackmouth.ui.Screens.HomeScreenRoute
import com.example.blackmouth.ui.Screens.LoginScreenRoute
import com.example.blackmouth.ui.Screens.RegisterScreenRoute
import com.example.blackmouth.ui.Screens.UserScreen.UserScreen
import com.example.blackmouth.ui.theme.BlackMouthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlackMouthTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination?.route
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (
                            currentDestination != LoginScreenRoute::class.qualifiedName &&
                            currentDestination != RegisterScreenRoute::class.qualifiedName
                        ){
                            NavBar(navController = navController)
                        }
                    }
                )
                { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = LoginScreenRoute
                    ){
                        composable <LoginScreenRoute>{
                            LoginScreen(
                                paddingValues = innerPadding,
                                navController = navController
                            )
                        }

                        composable<RegisterScreenRoute> {
                            RegisterScreen(
                                paddingValues = innerPadding,
                                navController = navController
                            )
                        }

                        composable<HomeScreenRoute> {
                            HomeScreen(
                                paddingValues = innerPadding,
                                navController = navController
                            )
                        }

                        composable<AccountScreenRoute>{
                            UserScreen(
                                paddingValues = innerPadding,
                                navController = navController
                            )
                        }
                    }

                }
            }
        }
    }
}

