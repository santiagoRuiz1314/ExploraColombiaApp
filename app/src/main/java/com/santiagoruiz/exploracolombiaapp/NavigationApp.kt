package com.santiagoruiz.exploracolombiaapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.santiagoruiz.exploracolombiaapp.ui.elements.AddPlaceScreen
import com.santiagoruiz.exploracolombiaapp.ui.elements.HomeScreen
import com.santiagoruiz.exploracolombiaapp.ui.elements.LoginScreen
import com.santiagoruiz.exploracolombiaapp.ui.elements.RegisterScreen

@Composable
fun NavigationApp(){
    val myNavController = rememberNavController()
    val startDestination = if (Firebase.auth.currentUser != null) "home" else "login"

    NavHost(
        navController = myNavController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ){
        composable(route = "login"){
            LoginScreen(
                onLoginSuccess = {
                    myNavController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToRegister = { myNavController.navigate("register") }
            )
        }
        composable(route = "register"){
            RegisterScreen(
                onRegisterSuccess = {
                    myNavController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToLogin = { myNavController.navigate("login") },
                onBackClick = { myNavController.popBackStack() }
            )
        }
        composable(route = "home"){
            HomeScreen(onClickAddPlace = {
                myNavController.navigate("add_place")
            }
            )

        }
        composable(route = "add_place"){
            AddPlaceScreen(
                onBackClick = { myNavController.popBackStack() }
            )

        }

    }
}
