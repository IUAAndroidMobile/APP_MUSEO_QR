package com.iua.museum.splash.datasource.repository

import com.iua.museum.splash.usecase.SplashUseCaseModel

interface ISplashRepository {

    suspend fun callGetAuthToken(): SplashUseCaseModel
}