package com.example.mvvmdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.models.Quote
import com.example.mvvmdemo.repositories.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomDbViewModel(private val quoteRepository: QuoteRepository) : ViewModel(){

    fun getQuotes() :LiveData<List<Quote>>{
        return quoteRepository.getQuote()
    }

    fun insertQuotes(quote: Quote){
        viewModelScope.launch (Dispatchers.IO)  {
            quoteRepository.insertQuote(quote)
        }
    }
}