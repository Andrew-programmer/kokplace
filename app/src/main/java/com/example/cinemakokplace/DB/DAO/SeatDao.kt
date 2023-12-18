package com.example.cinemakokplace.DB.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.cinemakokplace.DB.Models.Seat

@Dao
interface SeatDao {
    @Query("SELECT * FROM seats")
    fun getAll(): List<Seat>
}