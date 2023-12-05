package com.example.cinemakokplace.Network

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class JwtManager @Inject constructor(@ApplicationContext private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE)

    var token: String
        get() = sharedPreferences.getString(SAVE_TOKEN, "") ?: ""
        set(value) {
            with(sharedPreferences.edit()) {
                putString(SAVE_TOKEN, value)
                apply()
            }
        }

    fun clearToken() {
        with(sharedPreferences.edit()) {
            remove(SAVE_TOKEN)
            apply()
        }
    }

    companion object {
        private var instance: JwtManager? = null
        private const val MY_PREFERENCE = "KokPlace"
        private const val SAVE_TOKEN = "accessToken"

        fun getInstance(context: Context): JwtManager {
            return instance ?: synchronized(this) {
                instance ?: JwtManager(context).also { instance = it }
            }
        }
    }
}





