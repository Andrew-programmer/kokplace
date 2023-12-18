package com.example.cinemakokplace.DB.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "halls")
data class Hall(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "gridSize") val gridSize: Int,
    @ColumnInfo(name = "seatId") val seatId: Long
)
