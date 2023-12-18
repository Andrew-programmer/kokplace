package com.example.cinemakokplace.DB.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.cinemakokplace.DB.Models.HallWithSeats

@Dao
interface HallWithSeatsDao {

    /*@Query("SELECT * FROM halls WHERE id = :hallId")
    fun getSeatsByHallId(hallId: Int): List<HallWithSeats>*/

}