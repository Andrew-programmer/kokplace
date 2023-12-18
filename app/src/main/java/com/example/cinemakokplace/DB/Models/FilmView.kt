package com.example.cinemakokplace.DB.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(tableName = "filmsView")
data class FilmView(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "filmId") val filmId: Long,
    @ColumnInfo(name = "startTime") val startTime: LocalTime,
    @ColumnInfo(name = "dayOfWeek") val dayOfWeek: Int,
    @ColumnInfo(name = "hallId") val hallId: Long
)
