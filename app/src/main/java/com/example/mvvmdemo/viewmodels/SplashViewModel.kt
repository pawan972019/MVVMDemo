package com.example.mvvmdemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.models.apiModel.response.AppConfigResponse
import com.example.mvvmdemo.repositories.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class SplashViewModel(private val repository: Repository) : ViewModel() {

    val appConfigResponse: MutableLiveData<Response<AppConfigResponse>> = MutableLiveData()

   fun getAppConfig(){
       viewModelScope.launch {

           val response = repository.getAppConfig()
           appConfigResponse.value = response
       }
   }
}