package com.example.cinemakokplace

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.NavController
import com.example.cinemakokplace.Components.AuthInput
import com.example.cinemakokplace.Components.BottomBar
import com.example.cinemakokplace.Components.ConfirmButton
import com.example.cinemakokplace.Components.CustomDrawer
import com.example.cinemakokplace.Components.LogoutDialog
import com.example.cinemakokplace.Components.MenuItems
import com.example.cinemakokplace.Components.MovieCard
import com.example.cinemakokplace.Components.TopBar
import com.example.cinemakokplace.Network.JwtManager
import com.example.cinemakokplace.Network.Models.FilmResponse
import com.example.cinemakokplace.Network.Status.RegisterStatus
import com.example.cinemakokplace.Screens.Screens
import com.example.cinemakokplace.ui.theme.mainButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WatchNowScreen(
    navController: NavController,
    /*movielist: List<FilmResponse>*/
){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current


    var showDialog by remember { mutableStateOf(false) }


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
                content = {paddingValues ->
                    Spacer(modifier = Modifier.height(75.dp))
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        item {
                            Spacer(modifier = Modifier.height(55.dp))
                        }
                        items(5) {
                            MovieCard(navController = navController)
                        }
                    }
                },
                bottomBar = { BottomBar(navController, menuItems = MenuItems.WatchNow) }
            )
        }
    )
}
