package com.example.cinemakokplace.DB.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cinemakokplace.DB.Models.Film

@Dao
interface FilmDao {
    @Query("SELECT * FROM films")
    fun getAll(): List<Film>

    @Insert
    fun insert(film: Film)
}