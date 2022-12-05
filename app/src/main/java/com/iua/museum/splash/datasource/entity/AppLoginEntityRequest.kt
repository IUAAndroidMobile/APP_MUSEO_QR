package com.iua.museum.splash.datasource.entity

import com.google.gson.annotations.SerializedName
import com.iua.museum.BuildConfig

data class AppLoginEntityRequest(
    @SerializedName("username") val username: String = BuildConfig.BASE_APP_USER_NAME,
    @SerializedName("password") val password: String = BuildConfig.BASE_APP_USER_PASSWORD
)