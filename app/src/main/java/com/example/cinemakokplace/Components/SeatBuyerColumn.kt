package com.example.cinemakokplace.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.R
import com.example.cinemakokplace.ui.theme.backgroundMain
import com.example.cinemakokplace.ui.theme.mainButton

@Preview(showBackground = true)
@Composable
fun SeatBuyerRow(
    /*
    * seatRow: Int,
    * seatPlace: Int,
    * seatPrice: Int
    */
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(33.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier
            .fillMaxHeight()
            .width(150.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            ) {
            Icon(painter = painterResource(id = R.drawable.ticketone),
                contentDescription = "",
                modifier = Modifier.size(30.dp),
                tint = Color.White
            )
            Text(text = "3 row" /* TODO: Tie to hall row */,
                color = Color.White)
            Text(text = "4 place"/* TODO: Tie to hall row place */,
                color = Color.White)
        }

        Row (
            modifier = Modifier.fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "150 UAH"/* TODO: Tie to Ticket price */,
                color = Color(0xFFDF5021))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Clear,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SeatBuyerList() {
    LazyColumn() {
        items(5) {
            SeatBuyerRow()
        }
    }
}



