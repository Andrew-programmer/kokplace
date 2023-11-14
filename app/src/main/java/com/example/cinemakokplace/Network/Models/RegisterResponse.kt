package com.example.cinemakokplace.Network.Models

data class RegisterResponse(
    val successed: Boolean,
    val jwtToken: String,
    val errors: Map<String, List<String>>
)