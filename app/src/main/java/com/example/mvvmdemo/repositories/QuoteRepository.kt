package com.example.mvvmdemo.repositories

import androidx.lifecycle.LiveData
import com.example.mvvmdemo.dao.QuoteDao
import com.example.mvvmdemo.models.Quote

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuote():LiveData<List<Quote>>{
        return quoteDao.getQuote()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}