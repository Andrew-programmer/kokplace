package com.example.cinemakokplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cinemakokplace.Components.ConfirmButton
import com.example.cinemakokplace.Network.JwtManager
import com.example.cinemakokplace.Screens.Screens
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme

@Composable
fun SplashScreen(navController:NavController) {
    val jwtToken = JwtManager.getInstance(LocalContext.current).token
    if(!jwtToken.isNullOrBlank()) {
        navController.navigate(Screens.WatchNowScreen.route) {
            popUpTo(Screens.SplashScreen.route) {
                inclusive = true
            }
        }
    } else {
        CinemaKokPlaceTheme(dynamicColor = false) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Fragment(navController)
            }
        }
    }
}

@Composable
fun Fragment(navController: NavController){
       val screenHeight = LocalConfiguration.current.screenHeightDp
       Image(painter = painterResource(id = R.drawable.balls), contentDescription = "balls_image", alignment = Alignment.TopStart)

       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(10.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
       ){
           Image(painter = painterResource(id = R.drawable.cinema), contentDescription = "cinema_image", modifier = Modifier.absolutePadding(top = (screenHeight*0.15f).dp))
           Text(text = "Get your tickets right here and right now!", style = MaterialTheme.typography.labelLarge, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.absolutePadding(top=(screenHeight*0.05f).dp))
           Text(text = "Choose a cinema and reserve your seats within a couple of minutes!\n Access to tickets is always at your fingertips, just a few clicks, and you're all set!\n Register or log in to your account to get started.", style = MaterialTheme.typography.titleMedium, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.absolutePadding(top = (screenHeight*0.1f).dp, bottom = (screenHeight*0.02f).dp, left = 20.dp, right = 20.dp))
           ConfirmButton(OnClick = {navController.navigate(Screens.RegistrationScreen.route) }, text="Get Started!")
       }
}

