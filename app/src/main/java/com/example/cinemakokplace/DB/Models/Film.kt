package com.example.cinemakokplace.DB.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "films")
data class Film(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "durationMinutes") val durationMinutes: Int,
    @ColumnInfo(name = "director") val director: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "genre")val genre: String,
    /*val poster: ByteArray,*/
    @ColumnInfo(name = "releaseYear") val releaseYear: String
)