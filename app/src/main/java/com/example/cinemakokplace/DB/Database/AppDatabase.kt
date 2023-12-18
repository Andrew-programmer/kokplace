package com.example.cinemakokplace.DB.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cinemakokplace.DB.DAO.BuyerDao
import com.example.cinemakokplace.DB.DAO.FilmDao
import com.example.cinemakokplace.DB.DAO.FilmWithFilmViewsDao
import com.example.cinemakokplace.DB.DAO.HallDao
import com.example.cinemakokplace.DB.DAO.HallWithSeatsDao
import com.example.cinemakokplace.DB.DAO.SeatDao
import com.example.cinemakokplace.DB.Models.Hall
import com.example.cinemakokplace.DB.Models.Seat
import com.example.cinemakokplace.DB.Models.FilmView
import com.example.cinemakokplace.DB.Models.Film
import com.example.cinemakokplace.DB.Models.FilmWithFilmViews
import com.example.cinemakokplace.DB.TimeConverters

@Database(entities = [Film::class, Hall::class, Seat::class, FilmView::class], version = 1)
@TypeConverters(TimeConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun filmViewDao(): FilmViewDao
    abstract fun filmDao(): FilmDao
    abstract fun hallDao(): HallDao
    abstract fun seatDao(): SeatDao
    abstract fun filmWithFilmViewsDao(): FilmWithFilmViewsDao
    abstract fun hallWithSeatsDao(): HallWithSeatsDao
    abstract fun buyerDao(): BuyerDao

}