package com.iua.museum.splash.datasource.service

import com.iua.museum.splash.datasource.entity.AppLoginEntityRequest
import com.iua.museum.splash.datasource.entity.AppLoginEntityResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface ILoginService {

    @GET("/api/v1/login")
    suspend fun getAuthToken(@Body request: AppLoginEntityRequest): AppLoginEntityResponse
}