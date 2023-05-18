package com.pucuk.binar_challenge_ch_6.data.network

import com.google.android.datatransport.runtime.dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {
    const val  BASE_URL ="https://api.themoviedb.org/3/"
    val instance : ApiClient by lazy {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiClient::class.java)
    }
}