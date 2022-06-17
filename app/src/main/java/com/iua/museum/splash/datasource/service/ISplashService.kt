package com.iua.museum.splash.datasource.service

import com.iua.museum.splash.datasource.entity.SplashEntityResponse
import retrofit2.http.GET

interface ISplashService {

    @GET("/api/auth")
    suspend fun getAuthToken(): SplashEntityResponse
}