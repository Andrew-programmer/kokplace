package com.example.cinemakokplace.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.ui.theme.mainButton
import com.google.mlkit.vision.text.Text

@Composable
fun DateScroller(
    selectedDay: Boolean,
    dayOfMonth: Int,
    dayOfWeek: String
){
    var selected by remember { mutableStateOf(selectedDay) }
    if(selected) {
        Card(
            modifier = Modifier
                .height(61.dp)
                .width(65.dp)
                .clickable { selected = !selected },
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(mainButton),
            border = BorderStroke(1.dp, Color(0xFFF4F4F4))
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()) {
                Text(text = dayOfWeek, color = Color(0xFFF4F4F4))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = dayOfMonth.toString(), color = Color(0xFFF4F4F4))
            }
        }
    } else {
        Card(
            modifier = Modifier
                .height(61.dp)
                .width(65.dp)
                .clickable { selected = !selected  },
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(Color(0xFF484848)),
            border = BorderStroke(1.dp, Color(0xFFF4F4F4))
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()) {
                Text(text = dayOfWeek, color = Color(0xFFF4F4F4))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = dayOfMonth.toString(), color = Color(0xFFF4F4F4))
            }
        }
    }

}

@Composable
fun RowsOfData() {
    val DaysOfWeek = listOf<String>("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")
    val DaysOfMonth = listOf<Int>(1, 2, 3, 4, 5, 6, 7)
    val scrollableState by remember { mutableStateOf(0) }
    LazyRow {
        items(DaysOfWeek.size) { index ->
            DateScroller(selectedDay = index == scrollableState, dayOfMonth = DaysOfMonth[index], dayOfWeek = DaysOfWeek[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DateScrollerPreview(){
    RowsOfData()
}