package com.example.cinemakokplace.Network

import com.example.cinemakokplace.Network.Models.RegisterRequest
import com.example.cinemakokplace.Network.Models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface BuyersApi {

    @POST("/api/Auth/registerBuyer")
    suspend fun registerBuyer(@Body request: RegisterRequest): Response<RegisterResponse>

}