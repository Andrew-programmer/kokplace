package com.example.cinemakokplace.DB.Database

import androidx.room.Dao
import com.example.cinemakokplace.DB.Models.FilmView
import androidx.room.Query

@Dao
interface FilmViewDao {
    @Query("SELECT * FROM filmsView")
    fun getAll(): List<FilmView>

}
