package com.example.cinemakokplace.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme
import com.example.cinemakokplace.ui.theme.mainButton


@Composable
fun  ConfirmButton(
    text: String,
    OnClick: () -> Unit
) {
    CinemaKokPlaceTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .height(75.dp)
                .clickable(interactionSource = remember {
                    MutableInteractionSource()
                }, indication = rememberRipple(bounded = true, color = Color.White)) {
                    OnClick()
                }
                , colors = CardDefaults.cardColors(mainButton)
        ) {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = text, style = MaterialTheme.typography.titleLarge, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OneButton() {
    ConfirmButton(text = "Get Started!", OnClick = { /*TODO*/ })
}