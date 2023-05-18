package com.pucuk.binar_challenge_ch_6.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.pucuk.binar_challenge_ch_6.R

class SplashViewModel(private val app: Application): AndroidViewModel(app) {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    fun currentUser(navController: NavController) {
        val currentUser = auth.currentUser
        if (currentUser == null) navController.navigate(R.id.action_splashFragment_to_loginFragment)
        else reload(navController)
    }
    private fun reload(navController: NavController) {
        auth.currentUser?.reload()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                navController.navigate(R.id.action_splashFragment_to_loginFragment)
            } else {
                FirebaseAuth.getInstance().signOut()
            }
        }
    }
}