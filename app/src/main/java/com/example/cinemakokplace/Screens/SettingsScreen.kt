import android.widget.Space
import android.widget.ToggleButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cinemakokplace.Components.CustomSwitch
import com.example.cinemakokplace.Components.GridSeatsHall
import com.example.cinemakokplace.Components.SeatBuyerList
import com.example.cinemakokplace.Components.SeatBuyerRow
import com.example.cinemakokplace.Components.SeatTypeDeterminer
import com.example.cinemakokplace.Components.TopBar
import com.example.cinemakokplace.Network.Models.HallResponse
import com.example.cinemakokplace.Network.Models.SeatResponse
import com.example.cinemakokplace.R
import com.example.cinemakokplace.Screens.Screens
import com.example.cinemakokplace.ui.theme.mainButton
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen()
{
    val timeUntilStart = 10

    Scaffold(
        containerColor = Color(0xFF232323),
        topBar = {
            TopBar(
            cinemaAndCity = "Settings",
            isSessionScreen = false
        )},
        content = { paddingValues ->
            Box(modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize()) {
                Text(
                    text = "Movie sessions",
                    color = mainButton,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(start=20.dp,top=5.dp)
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    ) {
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                        Text(
                            text = "Send notifications",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        CustomSwitch()
                    }

                    Divider(
                        modifier = Modifier
                            .height(2.dp)
                            .fillMaxWidth(),
                        color = Color(0xFFD9D9D9)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextButton(
                                onClick = { /*TODO*/ },
                                content = {
                                    Text(
                                        text = "Notify",
                                        color = Color.White,
                                        style = MaterialTheme.typography.titleLarge,
                                        textAlign = TextAlign.Start
                                    )
                                },
                                contentPadding = PaddingValues(0.dp)
                            )
                            Text(
                                text = "${timeUntilStart}" + " minutes before movie starts",
                                color = Color(0xFFA9A9A9),
                                style = MaterialTheme.typography.labelSmall,
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(70.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(
                    modifier = Modifier.size(70.dp),
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    border = BorderStroke(2.dp, Color(0xFFD04618)),
                    colors = ButtonDefaults.buttonColors(mainButton)) {
                    Text(
                        text = "<",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    )
}