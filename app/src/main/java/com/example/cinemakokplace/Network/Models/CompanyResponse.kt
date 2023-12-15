package com.example.cinemakokplace.Network.Models

data class CompanyResponse(
    val id: Int,
    val name: String,
    val login: String,
    val email: String,
    val phone: String,
    val description: String,
    val logo: String,
    val cinemas: List<CinemaResponse>
)
