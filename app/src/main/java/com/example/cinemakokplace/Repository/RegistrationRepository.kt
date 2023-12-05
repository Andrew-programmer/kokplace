package com.example.cinemakokplace.Network

import com.example.cinemakokplace.Network.Models.LoginRequest
import com.example.cinemakokplace.Network.Models.RegisterRequest
import com.example.cinemakokplace.Network.Models.RegisterResponse
import retrofit2.Response
import javax.inject.Inject

class RegistrationRepository @Inject constructor(private val buyersApi: BuyersApi) {

    suspend fun registerBuyer(registerRequest: RegisterRequest): Response<RegisterResponse> {
        return buyersApi.registerBuyer(registerRequest)
    }

    suspend fun loginBuyer(loginRequest: LoginRequest): Response<RegisterResponse> {
        return buyersApi.loginBuyer(loginRequest)
    }
}