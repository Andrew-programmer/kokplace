package com.example.cinemakokplace.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.R
import com.example.cinemakokplace.ui.theme.mainButton
import java.text.Format

@Composable
@Preview(showBackground = true)
fun TicketComponent() {
    ElevatedCard(colors = CardDefaults.cardColors(Color(0xFFD8D6D8))) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = "Karavan Multiplex",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleLarge
                )
                OutlinedButton(border = BorderStroke(1.dp, mainButton), shape = RoundedCornerShape(3.dp), onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "", tint = mainButton)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "SHARE", color = mainButton)
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Movie",
                        color = Color(0xFF787878),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(text = "Interstellar", color = Color.Black)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "Format", color = Color(0xFF787878))
                    Text(text = "3D", color = Color.Black)
                }
            }
            Card(
                modifier = Modifier
                    .padding(10.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(2.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Date",
                            color = Color.Black,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(text = "April 17 / Wed",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge)
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(text = "Time",
                            color = Color.Black,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(text = "10:30",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                val cardModifier = Modifier
                    .weight(1f)
                    .padding(10.dp)

                Card(modifier = cardModifier,
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(2.dp)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        Text(text = "Row", style = MaterialTheme.typography.labelMedium)
                        Text(text = "2", style = MaterialTheme.typography.labelMedium)
                    }
                }
                Card(modifier = cardModifier,
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(2.dp)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        Text(text = "Place", style = MaterialTheme.typography.labelMedium)
                        Text(text = "5", style = MaterialTheme.typography.labelMedium)
                    }
                }
                Card(modifier = cardModifier,
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(2.dp)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        Text(text = "Hall", style = MaterialTheme.typography.labelMedium)
                        Text(text = "4", style = MaterialTheme.typography.labelMedium)
                    }
                }
                Card(modifier = cardModifier,
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(2.dp)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        Text(text = "Price", style = MaterialTheme.typography.labelMedium)
                        Text(text = "150 UAH", style = MaterialTheme.typography.labelMedium)
                    }
                }
            }

        }
        Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(Color.White), shape = RoundedCornerShape(2.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.SpaceAround) {
                Image(painter = painterResource(id = R.drawable.qr), contentDescription = "")
                Spacer(modifier = Modifier.height(20.dp))
                Column() {
                    Text(text = "Scan the QR code to check \n" + "if it's valid", style = MaterialTheme.typography.labelMedium, textAlign = TextAlign.Start)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "№1234567", style = MaterialTheme.typography.titleMedium, color = mainButton)
                }
            }
        }
    }
}