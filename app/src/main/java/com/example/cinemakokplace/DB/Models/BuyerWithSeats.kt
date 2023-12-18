package com.example.cinemakokplace.DB.Models

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Relation

@Dao
data class BuyerWithSeats(
    @Embedded val buyer: Buyer,
    @Relation(
        parentColumn = "id",
        entityColumn = "buyerId"
    )
    val seats: List<Seat>?
)
