package com.example.cinemakokplace.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cinemakokplace.Components.BackButton
import com.example.cinemakokplace.Components.TicketComponent
import com.example.cinemakokplace.Components.TopBar
import com.example.cinemakokplace.ui.theme.mainButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyticketsScreen(
    navController: NavController,
) {
    Scaffold(
        containerColor = Color(0xFF232323),
        topBar = {
            TopBar(
                cinemaAndCity = "My tickets",
                isSessionScreen = false
            )
        },
        content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(bottom = 5.dp)) {
                item {
                    Spacer(modifier = Modifier.height(65.dp))
                }
                repeat(5) {
                    item {
                        TicketComponent()
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(70.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(
                    modifier = Modifier.size(70.dp),
                    onClick = { navController.popBackStack() },
                    shape = CircleShape,
                    border = BorderStroke(2.dp, Color(0xFFD04618)),
                    colors = ButtonDefaults.buttonColors(mainButton)) {
                        Text(
                            text = "<",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )
                    }
            }
        }
    )
}

