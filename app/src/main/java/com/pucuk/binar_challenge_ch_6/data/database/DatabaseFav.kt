package com.pucuk.binar_challenge_ch_6.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataFav :: class], version = 1)
abstract class DatabaseFav : RoomDatabase() {

    abstract fun favDao() : DaoFav

    companion object{
        private var INSTANCE : DatabaseFav? = null

        fun getInstance(context: Context) :DatabaseFav? {
            if(INSTANCE == null){
                synchronized(DatabaseFav::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseFav::class.java, "Fav.db"
                    )
                        .build()
                }

            }
            return INSTANCE
        }

    }
}