package com.example.cinemakokplace

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemakokplace.Network.JwtManager
import com.example.cinemakokplace.Network.Models.LoginRequest
import com.example.cinemakokplace.Network.Models.RegisterRequest
import com.example.cinemakokplace.Network.Models.RegisterResponse
import com.example.cinemakokplace.Network.RegistrationRepository
import com.example.cinemakokplace.Network.Status.RegisterStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val buyerRepository: RegistrationRepository, @ApplicationContext private val context: Context) : ViewModel() {

    private val _registerResult = MutableLiveData<RegisterStatus>()
    val registerResult: LiveData<RegisterStatus> = _registerResult

    fun registerUser(login: String, password: String, email: String, phone: String) {
        viewModelScope.launch {
            try {
                val registerRequest = RegisterRequest(login, password, email, phone)
                val response = buyerRepository.registerBuyer(registerRequest)
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null && registerResponse.successed) {
                        _registerResult.value = RegisterStatus.Success
                        val jwtManager = JwtManager.getInstance(context)
                        jwtManager.token = registerResponse.jwtToken
                    } else {
                        _registerResult.value = RegisterStatus.Error
                    }
                } else {
                    _registerResult.value = RegisterStatus.Error
                }
            } catch (e: Exception) {
                _registerResult.value = RegisterStatus.Error
            }
        }
    }
    fun loginUser(login: String, password: String){
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(login, password)
                val response = buyerRepository.loginBuyer(loginRequest)
                if(response.isSuccessful){
                    val loginResponse = response.body()
                    if (loginResponse != null && loginResponse.successed){
                        _registerResult.value = RegisterStatus.Success
                        val jwtManager = JwtManager.getInstance(context)
                        jwtManager.token = loginResponse.jwtToken
                    }
                    else {
                        _registerResult.value = RegisterStatus.Error
                    }
                }
                else{
                    _registerResult.value = RegisterStatus.Error
                }
            }
            catch (e: Exception){
                _registerResult.value = RegisterStatus.Error
            }
        }
    }
}