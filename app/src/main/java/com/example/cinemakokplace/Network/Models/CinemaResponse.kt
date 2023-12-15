package com.example.cinemakokplace.Network.Models

data class CinemaResponse(
    val id: Int,
    val name: String,
    val location: String,
    val description: String,
    val companyLogin: String,
    val logo: String,
    val company: CompanyResponse
)
