package com.example.cinemakokplace.DB.Models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class FilmWithFilmViews(
    @Embedded
    val film: Film,
    @Relation(
        entity = FilmView::class,
        parentColumn = "id",
        entityColumn = "filmId"
    )
    val filmViews: List<FilmView>?
)