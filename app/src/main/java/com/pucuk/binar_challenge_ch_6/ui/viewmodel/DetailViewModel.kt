package com.pucuk.binar_challenge_ch_6.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pucuk.binar_challenge_ch_6.data.model.ResponseDetailFilm
import com.pucuk.binar_challenge_ch_6.data.network.ApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class DetailViewModel @Inject constructor(private val api: ApiClient) : ViewModel() {
    private val _movie = MutableLiveData<ResponseDetailFilm>()
    val movie: LiveData<ResponseDetailFilm> = _movie
    fun getFilm(movieId: Int) = viewModelScope.launch {
        _movie.postValue(api.getDetailFilm(movieId))
    }
}