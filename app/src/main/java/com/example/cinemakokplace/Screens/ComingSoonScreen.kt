package com.example.cinemakokplace.Screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cinemakokplace.Components.ButtomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ComingSoonScreen(navController: NavController) {
    Scaffold(bottomBar = { ButtomBar() }) {

    }
}