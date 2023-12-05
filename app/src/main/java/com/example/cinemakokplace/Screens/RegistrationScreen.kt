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
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cinemakokplace.Components.AuthInput
import com.example.cinemakokplace.Components.ConfirmButton
import com.example.cinemakokplace.Network.Status.RegisterStatus
import com.example.cinemakokplace.Screens.Screens
import com.example.cinemakokplace.ui.theme.mainButton

@Composable
fun RegistrationScreen(
    navController: NavController
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val registrationViewModel = hiltViewModel<RegisterViewModel>()
    var login by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    Image(
        painter = painterResource(id = R.drawable.balls),
        contentDescription = "balls_image",
        alignment = Alignment.TopStart
    )
    Column(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text( text = "Welcome!",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center);
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Let's help you get your tickets.",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center);
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2.5f)
                ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            AuthInput(modifier = Modifier
                .height(90.dp)
                .padding(top = 40.dp), placeholder = "Enter your login", onValueChange = { login = it })
            AuthInput(modifier = Modifier
                .height(90.dp)
                .padding(top = 40.dp), placeholder = "Enter your email", onValueChange = { email = it })
            AuthInput(modifier = Modifier
                .height(90.dp)
                .padding(top = 40.dp), placeholder = "Enter password", onValueChange = { password = it })
            AuthInput(modifier = Modifier
                .height(90.dp)
                .padding(top = 40.dp), placeholder = "Enter your phone", onValueChange = { phone = it })

            Spacer(modifier = Modifier.height(30.dp))

            Register(
                navController = navController,
                registerViewModel = registrationViewModel,
                login = login,
                password = password,
                email = email,
                phone = phone
            )


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(bottom = 10.dp)
            ,
            horizontalArrangement = Arrangement.Center) {
            Text(text = "Already have an account?",
                color = Color.White,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(10.dp) )
            ClickableText(
                text = AnnotatedString("Sign in"),
                style = TextStyle(
                    color = mainButton,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Monospace
                ),
                onClick = {
                    navController.navigate(Screens.LogInScreen.route) {
                        popUpTo(Screens.RegistrationScreen.route) {
                            inclusive = true
                        }
                    }
                })
        }
    }
}

@Composable
fun Register(navController: NavController, registerViewModel: RegisterViewModel, login: String, password: String, email: String, phone: String) {
    val status by registerViewModel.registerResult.observeAsState()
    when(status) {
        is RegisterStatus.Success -> {
            navController.navigate(Screens.WatchNowScreen.route) {
                popUpTo(Screens.RegistrationScreen.route) {
                    inclusive = true
                }
            }
        }
        is RegisterStatus.Error -> {
            Text(text = "error")
        }
        is RegisterStatus.Loading -> {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    color = Color(0xFF3CF283)
                )
            }
        }
        else -> {
            ConfirmButton(text = "Register", OnClick = {
                registerViewModel.registerUser(login, password, email, phone)
            })
        }
    }
}