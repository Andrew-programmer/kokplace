package com.example.cinemakokplace.DB.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "seats")
data class Seat(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "rowNumber") val rowNumber: Int,
    @ColumnInfo(name = "seatNumber") val seatNumber: Int,
    @ColumnInfo(name = "isVip") val isVip: Boolean,
    @ColumnInfo(name = "buyerId") val buyerId: Long?
)
