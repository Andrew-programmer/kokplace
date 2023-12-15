package com.example.cinemakokplace.Network.Models

data class FilmResponse(
    val id: Int,
    val title: String,
    val director: String,
    val description: String,
    val releaseYear: Int,
    val genre: String,
    val durationMinutes: Int,
    val poster: String,
    val filmViews: List<FilmViewResponse>
)
