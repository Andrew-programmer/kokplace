package com.example.cinemakokplace.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cinemakokplace.R
import com.example.cinemakokplace.ui.theme.mainButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieInfoScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Scaffold(containerColor = Color(0xFF232323),
        topBar = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.film),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
            }
        },
        content = { paddingValues ->
            Box(modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()) {
                Column(modifier = Modifier.verticalScroll(scrollState)) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Interstellar",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Text(
                            text = "2h 49min | Sci-Fi",
                            color = Color(0xFF8A8787),
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Synopsis",
                            color = Color(0xFF8A8787),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "In Earth's future, a global crop blight and second Dust Bowl are\n slowly rendering the planet uninhabitable. Professor Brand (Michael \nCaine), a brilliant NASA physicist, is working on plans to save\n mankind by transporting Earth's population to a new home via a\n wormhole. But first, Brand must send former NASA pilot Cooper\n (Matthew McConaughey) and a team of researchers through the\n wormhole and across the galaxy to find out which of three planets\n could be mankind's new home.",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Film’s release",
                            color = Color(0xFF8A8787),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "6.11.2014",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Director",
                            color = Color(0xFF8A8787),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "Christopher Nolan",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Age",
                            color = Color(0xFF8A8787),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "16+",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Country",
                            color = Color(0xFF8A8787),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "USA",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start =20.dp, end= 20.dp, bottom = 5.dp)
                    .height(70.dp)
                    .background(Color.Transparent),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(
                    modifier = Modifier.size(70.dp),
                    onClick = { navController.popBackStack() },
                    shape = CircleShape,
                    border = BorderStroke(2.dp, Color(0xFFD04618)),
                    colors = ButtonDefaults.buttonColors(mainButton)
                ) {
                    Text(
                        text = "<",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
        bottomBar = {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start =25.dp, end= 25.dp, bottom = 15.dp)
                        .height(35.dp)
                        .background(Color.Transparent),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Button(
                        onClick = { navController.navigate(Screens.SessionsScreen.route)},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)
                            .height(35.dp),
                        colors = ButtonDefaults.buttonColors(mainButton),
                        shape = RoundedCornerShape(4.dp),
                    ) {
                        Row(
                            Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Sessions",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                        }
                    }
                }


        })
}