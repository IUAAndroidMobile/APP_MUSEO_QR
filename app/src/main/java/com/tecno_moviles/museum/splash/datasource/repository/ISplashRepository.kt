package com.tecno_moviles.museum.splash.datasource.repository

import com.tecno_moviles.museum.splash.usecase.SplashUseCaseModel

interface ISplashRepository {

    suspend fun callGetAuthToken(): SplashUseCaseModel
}