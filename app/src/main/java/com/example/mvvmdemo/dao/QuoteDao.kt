package com.example.mvvmdemo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmdemo.models.Quote

@Dao
interface QuoteDao {

    @Query ("select * from quote")
    fun getQuote(): LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}