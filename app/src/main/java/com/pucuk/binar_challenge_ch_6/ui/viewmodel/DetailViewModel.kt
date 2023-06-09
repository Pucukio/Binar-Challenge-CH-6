package com.pucuk.binar_challenge_ch_6.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pucuk.binar_challenge_ch_6.data.local.database.FavoriteEntity
import com.pucuk.binar_challenge_ch_6.data.model.ResponseDetailFilm
import com.pucuk.binar_challenge_ch_6.data.network.ApiClient
import com.pucuk.binar_challenge_ch_6.data.repository.LocalRepository
import com.pucuk.binar_challenge_ch_6.data.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val localRepository: LocalRepository
) : ViewModel() {
    private val _movie = MutableLiveData<ResponseDetailFilm>()
    val movie: LiveData<ResponseDetailFilm> = _movie

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite

    private val _user = MutableLiveData<FirebaseUser?>()
    val user: LiveData<FirebaseUser?> = _user

    fun getDetailMovie(movieId: Int) = viewModelScope.launch(Dispatchers.IO) {
        _loadingState.postValue(true)
        delay(2000L)
        val response = networkRepository.getDetailMovie(movieId = movieId)
        viewModelScope.launch(Dispatchers.Main) {
            _loadingState.postValue(false)
            _movie.postValue(response)
        }
    }

    fun session() {
        if (Firebase.auth.currentUser != null) {
            _user.postValue(Firebase.auth.currentUser)
        } else {
            _user.postValue(null)
        }
    }

    fun addFavorite(favoriteEntity: FavoriteEntity) =
        viewModelScope.launch { localRepository.addFavorite(favoriteEntity) }

    fun deleteFavorite(id_movie: Int, uuid_user: String) =
        viewModelScope.launch { localRepository.deleteFavorite(id_movie, uuid_user) }

    fun isFavorite(id_movie: Int, uuid_user: String) = viewModelScope.launch {
        _isFavorite.postValue(
            localRepository.isFavorite(
                id_movie,
                uuid_user
            )
        )
    }
}