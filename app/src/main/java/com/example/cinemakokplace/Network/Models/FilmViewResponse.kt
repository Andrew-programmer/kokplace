package com.example.cinemakokplace.Network.Models

data class FilmViewResponse(
    val id: Int,
    val startTime: String,
    val filmId: Int,
    val filmResponse: FilmResponse,
    val hallId: Int,
    val hallResponse: HallResponse,
)

