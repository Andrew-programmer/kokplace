package com.example.cinemakokplace.Network.Status

sealed class RegisterStatus{
    object Loading : RegisterStatus()
    object Success : RegisterStatus()
    object Error: RegisterStatus()
}