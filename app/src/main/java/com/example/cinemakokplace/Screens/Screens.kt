package com.example.cinemakokplace.Screens

sealed class Screens(var route: String) {

    object ComingSoonScreen: Screens("coming_soon")
    object WatchNowScreen: Screens("watch_now")
    object SettingsScreen: Screens("settings")
    object MyTicketsScreen: Screens("my_tickets")
    object SessionScreen: Screens("session")
    object MessageFormScreen: Screens("message_form")
    object MovieInfoScreen: Screens("movie_info")
    object RegistrationScreen: Screens("registration")
    object LogInScreen: Screens("log_in")
    object SplashScreen: Screens("splash")
    object HelpScreen: Screens("help")
    object PersonalInformationScreen: Screens("personal")
}