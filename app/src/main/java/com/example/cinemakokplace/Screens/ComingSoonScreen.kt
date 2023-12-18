package com.example.cinemakokplace.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cinemakokplace.Components.BottomBar
import com.example.cinemakokplace.Components.CustomDrawer
import com.example.cinemakokplace.Components.LogoutDialog
import com.example.cinemakokplace.Components.MenuItems
import com.example.cinemakokplace.Components.TopBar
import com.example.cinemakokplace.Network.JwtManager
import com.example.cinemakokplace.Network.Models.FilmResponse
import com.example.cinemakokplace.R
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComingSoonScreen(navController: NavController) {
    val films: List<String> = listOf("Interstellar", "Drive", "5 Knights of Night", "The Dark Knight", "The Dark Knight Rises", "Inception", "Tenet", "Dunkirk", "The Prestige", "Memento", "Insomnia", "Batman Begins", "Following")
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    CinemaKokPlaceTheme(dynamicColor = false) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                CustomDrawer(
                    onItemSelected = mapOf(
                        "Cinemas" to { scope.launch { drawerState.close() } },
                        "Profile" to { scope.launch { drawerState.close() } },
                        "Help" to { scope.launch { drawerState.close() } },
                        "Return tickets" to { scope.launch { drawerState.close() } },
                        "Settings" to { scope.launch { drawerState.close() } },
                        "websitedomin.com" to { scope.launch { drawerState.close() } },
                        "Log out" to {
                            showDialog = true
                            scope.launch { drawerState.close() }
                        }
                    )
                )
                if(showDialog) {
                    LogoutDialog(onDismiss = { showDialog = false }) {
                        JwtManager.getInstance(context).clearToken()
                        navController.navigate(route = Screens.LogInScreen.route, builder = {
                            navController.popBackStack(Screens.WatchNowScreen.route, inclusive = true)
                        })
                    }
                }
            },
            content = {
                Scaffold(
                    topBar =  {
                        TopBar(cinemaAndCity = "Jakarta, Cinema KokPlace", drawerOpen = { scope.launch { drawerState.open() } })
                    },
                    bottomBar = { BottomBar(navController, menuItems = MenuItems.ComingSoon) }
                ) {
                    // Main screen content



                    //val film_names: List<String> = listOf("Interstellar", "Drive", "5 Knights of Night", "The Dark Knight", "The Dark Knight Rises", "Inception", "Tenet", "Dunkirk", "The Prestige", "Memento", "Insomnia", "Batman Begins", "Following")
                    val film_names:List<FilmResponse> = listOf()

                    LazyColumn(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)) {
                        item {
                            Text(
                                text = "from August 1",
                                color = Color.White,
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.fillMaxWidth().padding(5.dp)
                            )
                            Divider(
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                        items(films) { film ->
                            Box(modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .padding(15.dp)
                                .clickable { navController.navigate(Screens.MovieInfoScreen.route) }) {
                                Image(
                                    painter = painterResource(id = R.drawable.film),
                                    contentDescription = film,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                                Text(
                                    text = film,
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleLarge,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .absolutePadding(15.dp)
                                        .align(Alignment.BottomStart)
                                )
                            }
                        }
                    }
                }
            }
        )
    }

    /*Scaffold(bottomBar = { BottomBar() }) {

    }*/
}