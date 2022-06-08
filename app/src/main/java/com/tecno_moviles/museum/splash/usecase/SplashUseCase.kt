package com.tecno_moviles.museum.splash.usecase

import com.tecno_moviles.museum.base.BaseUseCase
import com.tecno_moviles.museum.splash.datasource.entity.SplashEntityRequest
import com.tecno_moviles.museum.splash.datasource.repository.ISplashRepository

class SplashUseCase(private val repository: ISplashRepository): BaseUseCase<SplashEntityRequest, SplashUseCaseModel>() {

    override suspend fun run(params: SplashEntityRequest): SplashUseCaseModel =
        repository.callGetAuthToken()

}