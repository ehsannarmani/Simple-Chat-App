package ir.ehsan.asmrchatapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.ehsan.asmrchatapp.screens.ChatScreen
import ir.ehsan.asmrchatapp.screens.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ){
        composable("login"){
            LoginScreen(navController = navController)
        }
        composable("chat/{name}", arguments = listOf(
            navArgument("name"){
                type = NavType.StringType
            }
        )){
            ChatScreen(name = it.arguments?.getString("name") ?: "")
        }
    }
}