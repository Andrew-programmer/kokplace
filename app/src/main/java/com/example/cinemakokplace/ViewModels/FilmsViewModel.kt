package com.example.cinemakokplace.ViewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemakokplace.DB.DAO.FilmDao
import com.example.cinemakokplace.DB.DAO.FilmWithFilmViewsDao
import com.example.cinemakokplace.DB.Models.Film
import com.example.cinemakokplace.DB.Models.FilmWithFilmViews
import com.example.cinemakokplace.Network.Status.RegisterStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(private val filmWithFilmViewsDao: FilmWithFilmViewsDao): ViewModel(){
    private val _filmResult  = MutableLiveData<List<FilmWithFilmViews>>()
    val filmResult: LiveData<List<FilmWithFilmViews>> = _filmResult

    /*fun getFilmList(){
        viewModelScope.launch{
            val daoResponse = filmWithFilmViewsDao.getAll()
            _filmResult.value = daoResponse
        }
    }*/

}