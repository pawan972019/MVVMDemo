package com.example.mvvmdemo.dbmanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmdemo.dao.QuoteDao
import com.example.mvvmdemo.models.Quote

@Database(entities = [Quote::class], version = 1)
abstract class RoomDBManager : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {

        private var INSTANCE: RoomDBManager? = null

        fun getDatabase(context: Context): RoomDBManager {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, RoomDBManager::class.java, "MVVMDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}