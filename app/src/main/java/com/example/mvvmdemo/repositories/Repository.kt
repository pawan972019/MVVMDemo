package com.example.mvvmdemo.repositories

import com.example.mvvmdemo.BuildConfig
import com.example.mvvmdemo.apiManager.RetrofitApiClient
import com.example.mvvmdemo.models.apiModel.request.AppConfigRequest
import com.example.mvvmdemo.models.apiModel.request.Locale
import com.example.mvvmdemo.models.apiModel.response.AppConfigResponse
import com.example.mvvmdemo.utils.AppConstants
import retrofit2.Response

class Repository {

    suspend fun getAppConfig() : Response<AppConfigResponse>{

        val locale = Locale("IN", "en", "android", BuildConfig.VERSION_NAME)
        val appConfigRequest = AppConfigRequest(locale, "1", "com.jet.wakau")

        return RetrofitApiClient.apiService.getAppConfig(AppConstants.CONTENT_TYPE, appConfigRequest)
    }
}