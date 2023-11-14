package com.example.cinemakokplace

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemakokplace.Components.AuthInput
import com.example.cinemakokplace.Components.ConfirmButton
import com.example.cinemakokplace.ui.theme.mainButton

@Composable
fun LoginScreen() {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Image(
        painter = painterResource(id = R.drawable.balls),
        contentDescription = "balls_image",
        alignment = Alignment.TopStart
    )
    Column(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text( text = "Welcome back!",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center);
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.welcomeback),
                contentDescription = "welcomeback",
                alignment = Alignment.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){


            AuthInput(modifier = Modifier
                .height(90.dp)
                .padding(top = 40.dp), placeholder = "Enter your email", onValueChange = {login = it})
            AuthInput(modifier = Modifier
                .height(90.dp)
                .padding(top = 40.dp), placeholder = "Enter password", onValueChange = {password = it})

            Spacer(modifier = Modifier.height(5.dp))
            ClickableText(
                text = AnnotatedString("Forgot password?"),
                style = TextStyle(
                    color = mainButton,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Monospace
                ),
                onClick = {})

            Spacer(modifier = Modifier.height(10.dp))

            ConfirmButton(text = "Log in", OnClick = {})


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(bottom = 10.dp)
            ,
            horizontalArrangement = Arrangement.Center) {
            Text(text = "Don’t have an account ?",
                color = Color.White,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(10.dp) )
            ClickableText(
                text = AnnotatedString("Sign up"),
                style = TextStyle(
                    color = mainButton,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Monospace
                ),
                onClick = {})
        }
    }
}

@Composable
@Preview
fun OverviewLogin() {
    CinemaKokPlaceTheme(dynamicColor = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen()
        }
    }
}