package com.example.cinemakokplace.Network

import androidx.annotation.RequiresApi
import com.example.cinemakokplace.Network.Models.LoginRequest
import com.example.cinemakokplace.Network.Models.RegisterRequest
import com.example.cinemakokplace.Network.Models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BuyersApi {

    @POST("/api/Auth/registerBuyer")
    suspend fun registerBuyer(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("/api/Auth/login")
    suspend fun loginBuyer(@Body request: LoginRequest): Response<RegisterResponse>

}