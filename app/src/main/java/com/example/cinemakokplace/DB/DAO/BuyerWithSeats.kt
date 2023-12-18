package com.example.cinemakokplace.DB.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.cinemakokplace.DB.Models.Seat

@Dao
interface BuyerWithSeats {
    @Query("SELECT * FROM seats WHERE buyerId = :buyerId")
    fun getSeatsbyBuyer(buyerId:Int): List<Seat>
}