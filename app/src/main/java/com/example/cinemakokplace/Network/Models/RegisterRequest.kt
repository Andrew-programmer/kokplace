package com.example.cinemakokplace.Network.Models

data class RegisterRequest(
    val login: String,
    val password: String,
    val email: String,
    val phone: String
)