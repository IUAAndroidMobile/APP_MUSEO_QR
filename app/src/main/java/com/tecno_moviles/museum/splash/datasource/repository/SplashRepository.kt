package com.tecno_moviles.museum.splash.datasource.repository

import com.tecno_moviles.museum.splash.datasource.service.ISplashService
import com.tecno_moviles.museum.splash.usecase.SplashUseCaseModel
import com.tecno_moviles.museum.splash.usecase.toUserModel

class SplashRepository(private val service: ISplashService): ISplashRepository {

    override suspend fun callGetAuthToken(): SplashUseCaseModel = service.getAuthToken().toUserModel()

}