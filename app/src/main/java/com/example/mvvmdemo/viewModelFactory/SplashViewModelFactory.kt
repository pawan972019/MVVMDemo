package com.example.mvvmdemo.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.repositories.Repository
import com.example.mvvmdemo.viewmodels.SplashViewModel

class SplashViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(repository) as T
    }
}