package com.example.cinemakokplace.DB.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buyers")
data class Buyer(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "password") val password: String
)

