package com.iua.museum.splash.datasource.entity

import com.iua.museum.BuildConfig

data class AppLoginEntityRequest(
    val username: String = BuildConfig.BASE_APP_USER_NAME,
    val password: String = BuildConfig.BASE_APP_USER_PASSWORD
)