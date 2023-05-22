package com.pucuk.binar_challenge_ch_6.data.repository

import com.pucuk.binar_challenge_ch_6.data.model.ResponseDetailFilm
import com.pucuk.binar_challenge_ch_6.data.model.ResponseFilm
import com.pucuk.binar_challenge_ch_6.data.network.ApiClient
import javax.inject.Inject


interface NetworkRepository {

    suspend fun getAllFilmPopular(
        page: Int = 1
    ): ResponseFilm

    suspend fun getDetailMovie(
        movieId: Int
    ): ResponseDetailFilm
}

class NetworkRepositoryImpl @Inject constructor(private val apiService: ApiClient) :
    NetworkRepository {
    override suspend fun getAllFilmPopular(page: Int): ResponseFilm =
        apiService.getAllFilmPopular()

    override suspend fun getDetailMovie(movieId: Int): ResponseDetailFilm =
        apiService.getDetailFilm(movieId)
}

