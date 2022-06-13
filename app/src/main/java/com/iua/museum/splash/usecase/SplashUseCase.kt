package com.iua.museum.splash.usecase

import com.iua.museum.base.BaseUseCase
import com.iua.museum.splash.datasource.entity.SplashEntityRequest
import com.iua.museum.splash.datasource.repository.ISplashRepository

class SplashUseCase(private val repository: ISplashRepository): BaseUseCase<SplashEntityRequest, SplashUseCaseModel>() {

    override suspend fun run(params: SplashEntityRequest): SplashUseCaseModel =
        repository.callGetAuthToken()

}