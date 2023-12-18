package com.example.cinemakokplace.Components

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cinemakokplace.DB.Models.Film
import com.example.cinemakokplace.DB.Models.FilmView
import com.example.cinemakokplace.DB.Models.FilmWithFilmViews
import com.example.cinemakokplace.DB.TimeConverters
import com.example.cinemakokplace.Network.Models.FilmResponse
import com.example.cinemakokplace.Network.Models.FilmViewResponse
import com.example.cinemakokplace.R
import com.example.cinemakokplace.Screens.Screens
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme
import com.example.cinemakokplace.ui.theme.mainButton


@Composable
fun MovieCard(
    navController: NavController
) {
    val title = "Interstellar"
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
    Spacer(modifier = Modifier.height(10.dp))
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 410.dp, height = 520.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xFF3F3D40)
        ),
    ) {
        Box(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.film),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(5.dp))
            )
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .absolutePadding(15.dp)
                    .align(Alignment.BottomStart)
            )
        }


        Spacer(modifier = Modifier.height(5.dp))


        Box(modifier = Modifier.padding(5.dp)) {
            RowsOfData()
        }


        Spacer(modifier = Modifier.height(10.dp))


        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(15.dp),
            horizontalItemSpacing = 40.dp,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(movies.size) { index ->

                TextButton(
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(60.dp, 20.dp),
                    onClick = {navController.navigate(Screens.SessionScreen.route)
                    } // Передать в качестве аргумента айди хола
                ){
                    Text(text = movies[index],
                        color = Color.White,
                        modifier = Modifier.size(60.dp, 15.dp),
                        style = MaterialTheme.typography.labelLarge)
                }

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        OtherCinemasButton()
    }

}

@Composable
fun OtherCinemasButton() {
    CinemaKokPlaceTheme {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp)
                .height(35.dp),
                colors = ButtonDefaults.buttonColors(mainButton),
                shape = RoundedCornerShape(4.dp),
        ) {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "in other cinemas", style = MaterialTheme.typography.titleMedium, color = Color.White)
            }
        }
    }
}


