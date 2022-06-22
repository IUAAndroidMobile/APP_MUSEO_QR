package com.iua.museum.splash.datasource.entity

import com.google.gson.annotations.SerializedName

data class SplashEntityResponse(
    @SerializedName("token") val token: String
)