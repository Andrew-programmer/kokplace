package com.example.cinemakokplace.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cinemakokplace.R
import com.example.cinemakokplace.Screens.Screens

@Composable
fun BackButton(
    y_offset: Dp,
    //Back: () -> Unit
    navController: NavController
) {
    Button(onClick = {
        navController.navigate(Screens.MyTicketsScreen.route)
                     },
        modifier = Modifier.size(90.dp).offset(y = y_offset),
        shape = CircleShape,
        border = BorderStroke(7.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        Icon(painter = painterResource(id = R.drawable.ticketone), contentDescription = "", tint = Color(0xFFF8531D))
    }
}

