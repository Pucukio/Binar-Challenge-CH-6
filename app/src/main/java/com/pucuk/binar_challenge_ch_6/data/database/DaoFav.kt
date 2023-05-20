package com.pucuk.binar_challenge_ch_6.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoFav {
    @Insert
    fun insertData(favData: DataFav)

    @Query("SELECT * FROM DataFav")
    fun getDataNote() : List<DataFav>
}