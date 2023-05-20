package com.pucuk.binar_challenge_ch_6.data.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class DataFav(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var date: String,
    var image: String,
) : Parcelable

