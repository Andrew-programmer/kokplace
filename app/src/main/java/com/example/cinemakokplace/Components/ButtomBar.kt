package com.example.cinemakokplace.Components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme
import com.example.cinemakokplace.ui.theme.backgroundMain
import com.example.cinemakokplace.ui.theme.mainButton

@Composable
fun ButtomBar(
    //WatchNow:() -> Unit,
    //GetTicket:() -> Unit,
    //ComingSoon:() -> Unit
) {
CinemaKokPlaceTheme(dynamicColor = false) {
    var currentItemId by remember {
        mutableStateOf(1)
    }
    Box(
        Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(MaterialTheme.colorScheme.primary)
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                Modifier.absolutePadding(left = 15.dp).weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                MenuItems.WatchNow.let { watchNow ->
                    MenuItem(item = watchNow, isSelected = watchNow.id == currentItemId, changeMenuItems = {
                        currentItemId = watchNow.id
                    })
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            BackButton(y_offset = -15.dp)
            Spacer(modifier = Modifier.weight(1f))
            Column(
                Modifier.absolutePadding(right = 15.dp).weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                MenuItems.ComingSoon.let { comingSoon ->
                    MenuItem(item = comingSoon, isSelected = comingSoon.id == currentItemId, changeMenuItems = {
                        currentItemId = comingSoon.id
                    })
                }
            }
        }
    }
}
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuItem(
    item: MenuItems,
    isSelected: Boolean,
    changeMenuItems: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(mainButton),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.clickable(interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true, color = Color.White)
        ) {
            changeMenuItems()
        }

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(35.dp),
                painter = painterResource(id = item.iconId),
                contentDescription = item.menuName,
                tint = Color.White
            )
            Text(
                text = item.menuName,
                color = Color.White,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(2.dp))
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Color.White)
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Main() {
    Scaffold(bottomBar = { ButtomBar()}) {

    }
}
