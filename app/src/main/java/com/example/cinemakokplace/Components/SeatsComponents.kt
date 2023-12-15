package com.example.cinemakokplace.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.Network.Models.SeatResponse
import com.example.cinemakokplace.R


@Composable
fun SeatIcon(seat: SeatResponse) {
    if (seat.isBooked) {
       Icon(painter = painterResource(id = R.drawable.vectorseat), contentDescription = "dd", tint = Color(0xFF585858))
    } else {
        if (seat.isVIP) {
            Icon(painter = painterResource(id = R.drawable.vectorseat), contentDescription = "dd", tint = Color(0xFF926F17))
        } else {
            Icon(painter = painterResource(id = R.drawable.vectorseat), contentDescription = "dd", tint = Color(0xFF803B24))
        }
    }
}

@Composable
fun GridSeatsHall(seats: List<SeatResponse>, gridSize: Int) {
    val seatMatrix = List(gridSize) { MutableList<SeatResponse?>(gridSize) { null } }

    seats.forEach { seat ->
        if (seat.rowNumber in 0 until gridSize && seat.seatNumber in 0 until gridSize) {
            seatMatrix[seat.rowNumber][seat.seatNumber] = seat
        }
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(gridSize),
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier.background(Color.Black)
    ) {
        items(seatMatrix.flatten()) { seat ->
            seat?.let {
                SeatIcon(it)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
/* Комментарии для Антона (прочитай их)
* Сделал так сказать свой паттерн для рисования разных видов мест (для наглядности и тестирования)
* Вроде работает
* Значит не трожь */
fun TestIng() {
    val seats = mutableListOf<SeatResponse>()
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

    GridSeatsHall(seats, 20)
}