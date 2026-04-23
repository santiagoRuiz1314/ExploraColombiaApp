package com.santiagoruiz.exploracolombiaapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationApp(){
    val myNavController = rememberNavController()
    NavHost(
        navController = myNavController,
        startDestination = "login",
        modifier = Modifier.fillMaxSize()
    ){
        composable(route = "login"){
            LoginScreen(onLoginSuccess = {}, onNavigateToRegister = {myNavController.navigate("register")})

        }
        composable(route = "register"){
            RegisterScreen(onRegisterSuccess = {}, onNavigateToLogin = {myNavController.navigate("login")},  onBackClick = { myNavController.popBackStack() } )
        }
    }
}