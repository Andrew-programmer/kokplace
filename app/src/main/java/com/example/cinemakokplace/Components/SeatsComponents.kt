package com.example.cinemakokplace.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.Network.Models.SeatResponse
import com.example.cinemakokplace.R
import com.example.cinemakokplace.ui.theme.mainButton


@Composable
fun SeatIcon(seat: SeatResponse) {
    val iconSize = 14.dp
    if (seat.isBooked) {
        IconButton(onClick ={}, Modifier.size(iconSize)){
            Icon(painter = painterResource(id = R.drawable.vectorseat), contentDescription = "dd", tint = Color(0xFF585858))
        }
    } else {
        if (seat.isVIP) {
            IconButton(onClick ={}, Modifier.size(iconSize)){
                Icon(painter = painterResource(id = R.drawable.vectorseat), contentDescription = "dd", tint = Color(0xFF926F17))
            }
        } else {
            IconButton(onClick ={}, Modifier.size(iconSize)){
                Icon(painter = painterResource(id = R.drawable.vectorseat), contentDescription = "dd", tint = Color(0xFFDF5021))
            }
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
        modifier = Modifier
            .background(Color(0xFF232323))
            .padding(start = 10.dp, end = 10.dp)
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
// Хорошо :)
fun TestIng() {
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
    /*Row {
        Icon(bitmap = , contentDescription = )
    }*/
    GridSeatsHall(seats, 20)
    Row {
        SeatTypeDeterminer("GOOD", 150, mainButton)
        SeatTypeDeterminer("LUX", 250, Color(0xFF926F17))
    }
}
