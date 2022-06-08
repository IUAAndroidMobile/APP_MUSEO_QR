package com.tecno_moviles.museum.splash.datasource.service

import com.tecno_moviles.museum.splash.datasource.entity.SplashEntityResponse
import retrofit2.http.GET

interface ISplashService {

    @GET("api/auth")
    suspend fun getAuthToken(): SplashEntityResponse
}