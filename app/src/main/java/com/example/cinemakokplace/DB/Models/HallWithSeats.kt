package com.example.cinemakokplace.DB.Models

import androidx.room.Embedded
import androidx.room.Relation

data class HallWithSeats(
    @Embedded
    val hall: Hall,
    @Relation(
        entity = Seat::class,
        parentColumn = "id",
        entityColumn = "hallId"
    )
    val seats: List<Seat>?
)
