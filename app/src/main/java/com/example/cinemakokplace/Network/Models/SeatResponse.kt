package com.example.cinemakokplace.Network.Models

data class SeatResponse(
    val id: Int,
    val rowNumber: Int,
    val seatNumber: Int,
    val hallId: Int,
    val isVIP: Boolean,
    val hall: HallResponse?,
    val isBooked: Boolean // Пока что нет этого поля в бэке но его можно получить через запрос GET /api/SeatBookings/
)
