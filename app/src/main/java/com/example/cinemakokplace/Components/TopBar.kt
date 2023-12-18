package com.example.cinemakokplace.Components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cinemakokplace.R
import com.example.cinemakokplace.ui.theme.mainButton


@Composable
fun TopBar(
    cinemaAndCity: String,
    drawerOpen: () -> Unit = {},
    isSessionScreen: Boolean = false,
    BackButton: () -> Unit = {}
) {
    Row(verticalAlignment = Alignment.CenterVertically
        ,horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(mainButton)
        ){
        if (isSessionScreen) {
            IconButton(onClick = { BackButton() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "navdrawer", tint = Color.White, modifier = Modifier.height(30.dp).width(30.dp))
            }
        } else {
            IconButton(onClick = {  drawerOpen() }) {
                Icon(painter = painterResource(id = R.drawable.burger_menu), contentDescription = "navdrawer", tint = Color.White, modifier = Modifier.height(30.dp).width(30.dp))
            }
        }
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = cinemaAndCity,
            color = Color.White,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Start)
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    TopBar(cinemaAndCity = "Cinema KokPlace - Jakarta", drawerOpen = { /*TODO*/ })
}