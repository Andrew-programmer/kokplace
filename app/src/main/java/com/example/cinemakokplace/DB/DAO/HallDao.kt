package com.example.cinemakokplace.DB.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.cinemakokplace.DB.Models.Hall

@Dao
interface HallDao {
    @Query("SELECT * FROM halls")
    fun getAll(): List<Hall>
}