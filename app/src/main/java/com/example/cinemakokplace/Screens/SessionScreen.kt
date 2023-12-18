import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionScreen(
    navController: NavController
    /*val hallResponse:HallResponse*/
) {
    Scaffold(containerColor = Color(0xFF232323),
        topBar = {
             TopBar(
                 cinemaAndCity = "Jakarta, Cinema KokPlace",
                 isSessionScreen = true,
                 BackButton = {navController?.popBackStack()}
             )
         },
        content = { paddingValues ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .width(244.dp)
                        .height(106.dp)
                        .border(2.dp, Color(0xFFF8531D), RoundedCornerShape(5.dp))
                        ,
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(Color(0xFF3F3D40)),
                )
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "10:30 - 13:30",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Hall №6 3D",
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(
                            text = "April 17",
                            color = Color.White,
                            style = MaterialTheme.typography.titleSmall,
                        )
                    }


                }
                Spacer(modifier = Modifier.height(20.dp))
                Icon(painter = painterResource(id = R.drawable.screen), contentDescription = "", tint = mainButton,
                    modifier = Modifier.padding(2.dp))
                Text(
                    text = "Screen",
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall,
                )
                /*GRID COMPONENT STARTS HERE*/
                val seats = mutableListOf<SeatResponse>()
                // Достать кол-во сидений с hallResponse
                for (row in 0 until 20) {
                    for (column in 0 until 20) {
                        if (row < 17) { // Удаляем последние 3 ряда (для наглядности что мы можем рисовать не только квадратные залы)
                            if (!(column in 8..11 && row in 6..10)) { // Удаляем прямоугольную область в центре зала для наглядности отсутствия мест
                                seats.add(
                                    SeatResponse(
                                        id = row * 20 + column,
                                        rowNumber = row,
                                        seatNumber = column,
                                        hallId = 1,
                                        isVIP = row == 0, // Первый ряд - VIP
                                        hall = null,
                                        isBooked = (row + column) % 2 == 0 // Забронированные места в шахматном порядке
                                    )
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                GridSeatsHall(seats = seats, gridSize = 20)
                /*GRID COMPONENT ENDS HERE*/
                Box (modifier = Modifier.fillMaxWidth()){
                    Row(modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.Start) {
                        SeatTypeDeterminer(seatType = "GOOD",seatPrice = 150, seatColor = mainButton)
                        Spacer(modifier = Modifier.width(10.dp))
                        SeatTypeDeterminer(seatType = "LUX" , seatPrice = 250, seatColor = Color.Yellow)
                    }
                }

                SeatBuyerList()
            }
        },
        bottomBar = {
            Column(modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color(0xFF232323))
                .drawWithContent {
                    drawContent()
                    drawLine(
                        color = Color(0xFFD9D9D9),
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = Stroke(2.dp.toPx()).width
                    )
                }
            ) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .padding(start = 10.dp, end = 0.dp)
                ) {
                    Text(
                        text = "5 / 850 UAH",
                        color = Color(0xFFDF5021),
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }
                Button(
                    onClick = {
                        navController.navigate(Screens.MyTicketsScreen.route)
                     },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(mainButton),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Row(
                        Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Continue",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    }
                }
            }
        }
    )
}