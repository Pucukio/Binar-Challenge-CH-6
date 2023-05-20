package com.pucuk.binar_challenge_ch_6.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pucuk.binar_challenge_ch_6.data.database.DaoFav
import com.pucuk.binar_challenge_ch_6.data.database.DataFav
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val daoFav: DaoFav) : ViewModel() {
    private val _user = MutableLiveData<FirebaseUser?>()
    val user: LiveData<FirebaseUser?> = _user

    fun session() {
        if (Firebase.auth.currentUser != null) {
            _user.postValue(Firebase.auth.currentUser)
        } else {
            _user.postValue(null)
        }
    }
}