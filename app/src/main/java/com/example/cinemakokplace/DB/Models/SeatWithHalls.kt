package com.example.cinemakokplace.DB.Models

import androidx.room.Embedded
import androidx.room.Relation

data class SeatWithHalls(
    @Embedded
    val seat: Seat,
    @Relation(
        entity = Hall::class,
        parentColumn = "id",
        entityColumn = "seatId"
    )
    val halls: List<Hall>?
)
