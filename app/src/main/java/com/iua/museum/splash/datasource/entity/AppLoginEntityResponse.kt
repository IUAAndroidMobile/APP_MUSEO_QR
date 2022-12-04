package com.iua.museum.splash.datasource.entity

import com.google.gson.annotations.SerializedName

data class AppLoginEntityResponse(
    @SerializedName("token") val token: String
)