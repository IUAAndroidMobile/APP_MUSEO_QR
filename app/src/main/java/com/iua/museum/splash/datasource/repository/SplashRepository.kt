package com.iua.museum.splash.datasource.repository

import com.iua.museum.splash.datasource.service.ISplashService
import com.iua.museum.splash.usecase.SplashUseCaseModel
import com.iua.museum.splash.usecase.toUserModel

class SplashRepository(private val service: ISplashService): ISplashRepository {

    override suspend fun callGetAuthToken(): SplashUseCaseModel = service.getAuthToken().toUserModel()

}