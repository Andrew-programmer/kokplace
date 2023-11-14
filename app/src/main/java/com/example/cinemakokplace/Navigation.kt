package com.example.cinemakokplace

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinemakokplace.Screens.ComingSoonScreen
import com.example.cinemakokplace.Screens.Screens


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screens.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }
//        composable(Screens.LogInScreen.route) {
//        }
        composable(Screens.ComingSoonScreen.route) {
            ComingSoonScreen(navController = navController)
        }
//        composable(Screens.MyTicketsScreen.route) {
//        }
//        composable(Screens.SettingsScreen.route) {
//        }
//        composable(Screens.SessionScreen.route){
//        }
//        composable(Screens.ComingSoonScreen.route) {
//        }
//        composable(Screens.HelpScreen.route) {
//        }
//        composable(Screens.MovieInfoScreen.route) {
//        }
//        composable(Screens.PersonalInformationScreen.route) {
//
//        }

    }

}