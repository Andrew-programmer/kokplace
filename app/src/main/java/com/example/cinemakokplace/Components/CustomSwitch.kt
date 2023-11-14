package com.example.cinemakokplace.Components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun CustomSwitch(
) {
    var switched by remember {
        mutableStateOf(false)
    }
    val x_movement by animateDpAsState(
        targetValue = if (switched) 0.dp else 25.dp,
        animationSpec = tween(durationMillis = 400)
    )

    Box (  //Ограничивающий бокс
        Modifier
            .width(50.dp)
            .height(25.dp)
            .clip(CircleShape)
            .clickable { switched = !switched }
            .background(Color(0xFF7f3820))){
        Box ( //Шарик с анимацией
            Modifier
                .size(25.dp)
                .offset(x = x_movement)
                .padding(all = 4.dp)
                .clip(CircleShape)
                .background(Color(0xFFF8531D))) {}
    }
}