package com.example.cinemakokplace.DI

import android.content.Context
import androidx.room.Room
import com.example.cinemakokplace.DB.DAO.BuyerDao
import com.example.cinemakokplace.DB.DAO.FilmDao
import com.example.cinemakokplace.DB.DAO.FilmWithFilmViewsDao
import com.example.cinemakokplace.DB.DAO.HallDao
import com.example.cinemakokplace.DB.DAO.SeatDao
import com.example.cinemakokplace.DB.Database.AppDatabase
import com.example.cinemakokplace.DB.Database.FilmViewDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideHallDao(appDatabase: AppDatabase): HallDao {
        return appDatabase.hallDao()
    }

    @Provides
    fun provideSeatDao(appDatabase: AppDatabase): SeatDao {
        return appDatabase.seatDao()
    }

    @Provides
    fun provideFilmViewDao(appDatabase: AppDatabase): FilmViewDao {
        return appDatabase.filmViewDao()
    }

    @Provides
    fun provideFilmDao(appDatabase: AppDatabase): FilmDao {
        return appDatabase.filmDao()
    }

    @Provides
    fun provideFilmWithFilmViewsDao(appDatabase: AppDatabase): FilmWithFilmViewsDao {
        return appDatabase.filmWithFilmViewsDao()
    }
    @Provides
    fun provideBuyer(appDatabase: AppDatabase): BuyerDao{
        return appDatabase.buyerDao()
    }

    @Provides
    @Singleton
    fun provideMyDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context = context, AppDatabase::class.java, "cinema_db").allowMainThreadQueries().build()
    }
}