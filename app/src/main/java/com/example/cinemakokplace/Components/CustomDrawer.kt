package com.example.cinemakokplace.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.R
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme
import com.example.cinemakokplace.ui.theme.Disabled
import com.example.cinemakokplace.ui.theme.backgroundMain
import com.example.cinemakokplace.ui.theme.backgroundSecondary
import com.example.cinemakokplace.ui.theme.mainButton

@Composable
fun CustomDrawer(
    onItemSelected: Map<String, () -> Unit>
) {
    val buttonLabels = listOf("Cinemas", "Profile", "Help", "Return tickets", "Settings", "websitedomin.com", "Log out")
    CinemaKokPlaceTheme(dynamicColor = false) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(300.dp)
                .background(backgroundMain),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .absolutePadding(top = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.figni), contentDescription = "imgfigni")
                Text(text = "KokPlace", style = MaterialTheme.typography.bodyLarge, color = Color.White, modifier = Modifier.padding(10.dp))
            }

            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .absolutePadding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                buttonLabels.forEach { label ->
                    val textColor = if (label == buttonLabels.last()) Color.Red else Color.White
                    val icon = if (label == buttonLabels.last()) painterResource(id = R.drawable.exit) else painterResource(id = R.drawable.arrow)
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { onItemSelected[label]?.invoke() },
                            colors = ButtonDefaults.buttonColors(backgroundMain),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            contentPadding = PaddingValues(0.dp),
                            shape = RoundedCornerShape(0.dp),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = label,
                                    style = MaterialTheme.typography.titleLarge,
                                    color = textColor,
                                    modifier = Modifier.padding(start = 10.dp)
                                )
                                Icon(
                                    modifier = Modifier.size(10.dp, 12.dp),
                                    painter = icon,
                                    contentDescription = "home",
                                    tint = Color.White
                                )
                            }
                        }

                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.White
                    )
                }
            }

            Column(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .absolutePadding(top = 25.dp, right = 15.dp, left = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Card (
                    Modifier
                        .fillMaxHeight(0.8f),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(backgroundSecondary)
                    ){
                    Row (Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier = Modifier.fillMaxHeight().padding(start = 20.dp), verticalArrangement = Arrangement.Center) {
                            Text(text = "Dnipro", style = MaterialTheme.typography.labelLarge, color = Color.White)
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(text = "Karavan Multiplex", style = MaterialTheme.typography.labelLarge, color = Color.White)
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Nyzhn’odniprovs’ka St, 17", style = MaterialTheme.typography.titleMedium, color = Disabled)
                        }
                        Column(modifier = Modifier.fillMaxHeight().padding(end = 10.dp), verticalArrangement = Arrangement.Center) {
                            Card (Modifier.size(38.dp, 38.dp), shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(mainButton)) {
                                Icon(
                                    modifier = Modifier.size(38.dp, 38.dp),
                                    painter = painterResource(id = R.drawable.arrow),
                                    contentDescription = "home",
                                    tint = backgroundSecondary
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Card (Modifier.size(38.dp, 38.dp), shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(mainButton)) {
                                Icon(
                                    modifier = Modifier.size(38.dp, 38.dp),
                                    painter = painterResource(id = R.drawable.arrow),
                                    contentDescription = "home",
                                    tint = backgroundSecondary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
