package com.example.cinemakokplace.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.example.cinemakokplace.Components.DateScroller
import com.example.cinemakokplace.Components.RowsOfData
import com.example.cinemakokplace.R
import com.example.cinemakokplace.ui.theme.mainButton

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SessionsScreen(
    navController: NavController
) {
    val movies = listOf<String>(
        "10:20",
        "8:00",
        "11:20",
        "80:08",
        "09:11",
        "69:69",
        "04:12",
        "10:20"
    )
    Scaffold(
        containerColor = Color(0xFF232323),
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
            Box(modifier = Modifier.padding(paddingValues = paddingValues)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top=30.dp,bottom = 15.dp, start = 15.dp, end = 15.dp), horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Interstellar",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight(700),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    RowsOfData()
                    Column(modifier = Modifier.padding(top = 30.dp)) {
                        Text(text = "Karavan Multiplex", color = mainButton, style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Start, fontWeight = FontWeight.Bold)
                        Text(text = "Nyzhn’odniprovs’ka St, 17", color = Color(0xFF8A8787), style = MaterialTheme.typography.labelMedium, textAlign = TextAlign.Start, fontWeight = FontWeight.Bold)
                    }
                    Divider(modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                       , color = Color.White)
                    LazyHorizontalStaggeredGrid(
                        rows = StaggeredGridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(15.dp),
                        horizontalItemSpacing = 40.dp,
                        verticalArrangement = Arrangement.spacedBy(25.dp)
                    ) {
                        items(movies.size) { index ->

                            Text(
                                text = movies[index],
                                color = Color.White,
                                modifier = Modifier.size(60.dp, 10.dp),
                                style = MaterialTheme.typography.titleMedium,
                            )

                        }
                    }
                }
            }
        },
        floatingActionButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 5.dp)
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
        }
    )
}