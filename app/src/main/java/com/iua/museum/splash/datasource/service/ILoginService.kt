package com.iua.museum.splash.datasource.service

import com.iua.museum.splash.datasource.entity.AppLoginEntityResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface ILoginService {

    @POST("/api/v1/login/json")
    suspend fun getAuthToken(@Query("username") username: String, @Query("password") password: String): AppLoginEntityResponse
}