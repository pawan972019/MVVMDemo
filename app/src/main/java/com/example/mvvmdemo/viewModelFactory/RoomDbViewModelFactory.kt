package com.example.mvvmdemo.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.repositories.QuoteRepository
import com.example.mvvmdemo.viewmodels.RoomDbViewModel

class RoomDbViewModelFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RoomDbViewModel(quoteRepository) as T
    }

}