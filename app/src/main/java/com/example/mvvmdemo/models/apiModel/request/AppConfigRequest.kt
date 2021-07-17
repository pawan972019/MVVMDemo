package com.example.mvvmdemo.models.apiModel.request

data class AppConfigRequest(
    val locale: Locale,
    val noSecure: String,
    val packageName: String
)

data class Locale(
    val country: String,
    val language: String,
    val platform: String,
    val version: String
)