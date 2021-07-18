package com.example.mvvmdemo.apiManager

import com.example.mvvmdemo.models.apiModel.request.AppConfigRequest
import com.example.mvvmdemo.models.apiModel.response.AppConfigResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiService {

    @POST("config/appConfig_1_0")
    suspend fun getAppConfig(@Header("Content-Type") content_type: String?, @Body appConfigRequest: AppConfigRequest): Response<AppConfigResponse>

}