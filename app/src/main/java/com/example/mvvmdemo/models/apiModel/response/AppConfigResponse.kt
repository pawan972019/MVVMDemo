package com.example.mvvmdemo.models.apiModel.response

data class AppConfigResponse(
    val `data`: Data
)

data class Data(
    val code: Int,
    val `data`: DataX,
    val message: String,
    val status: String
)

data class DataX(
    val OTPResendTime: Int,
    val ageRestriction: Int,
    val analyticsDetail: AnalyticsDetail,
    val appSetting: AppSetting,
    val appShareDetails: AppShareDetails,
    val attemptOtpLimit: Int,
    val blockApps: List<String>,
    val cameraSetting: CameraSetting,
    val defaultLanguageId: String,
    val emojis: List<String>,
    val logEnabled: Int,
    val maintenanceSetting: MaintenanceSetting,
    val packageName: String,
    val platform: String,
    val rateUsCount: Int,
    val showLikedVideo: Int,
    val updateDetails: UpdateDetails,
    val userNameLimit: Int,
    val webViewURLs: WebViewURLs
)

data class AnalyticsDetail(
    val analyticsAuthorization: String
)

data class AppSetting(
    val inAppRatingEnabled: Int,
    val trendingDataRefreshTime: Int
)

data class AppShareDetails(
    val appShareText: String,
    val appShareUrl: String
)

data class CameraSetting(
    val filterURL: String,
    val showVideo: Int,
    val videoURLs: List<VideoURL>
)

data class MaintenanceSetting(
    val maintenanceFlag: Int,
    val maintenanceMessage: String
)

data class UpdateDetails(
    val forceUpdate: String,
    val forceUpdateText: String,
    val optionalUpdate: String,
    val optionalUpdateText: String
)

data class WebViewURLs(
    val privacyURL: String,
    val termsURL: String
)

data class VideoURL(
    val language: String,
    val url: String
)