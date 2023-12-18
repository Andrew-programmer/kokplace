package com.example.cinemakokplace.DB.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cinemakokplace.DB.Models.FilmWithFilmViews

@Dao
interface FilmWithFilmViewsDao {
    /*@Query("SELECT * FROM filmsView")
    fun getAll(): List<FilmWithFilmViews>

    @Query("SELECT * FROM filmsView WHERE startTime = :startTime")
    fun getFilmByStartTime(startTime: String): FilmWithFilmViews*/
}