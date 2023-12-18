package com.example.cinemakokplace

import SessionScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinemakokplace.Screens.ComingSoonScreen
import com.example.cinemakokplace.Screens.MovieInfoScreen
import com.example.cinemakokplace.Screens.MyticketsScreen
import com.example.cinemakokplace.Screens.Screens
import com.example.cinemakokplace.Screens.SessionsScreen


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
        composable(Screens.WatchNowScreen.route){
           WatchNowScreen(navController = navController)
        }
        composable(Screens.LogInScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screens.MyTicketsScreen.route) {
            MyticketsScreen(navController = navController)
        }
        /*composable(Screens.SettingsScreen.route) {
            Screens.SettingsScreen(navController = navController)
        }*/
        composable(Screens.SessionScreen.route){
            SessionScreen(navController = navController)
        }
        composable(Screens.SessionsScreen.route){
            SessionsScreen(navController = navController)
        }

//        composable(Screens.HelpScreen.route) {
//        }
        composable(Screens.MovieInfoScreen.route) {
            MovieInfoScreen(navController = navController)
        }
//        composable(Screens.PersonalInformationScreen.route) {
//
//        }

    }

}