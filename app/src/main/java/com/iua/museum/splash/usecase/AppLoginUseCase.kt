package com.iua.museum.splash.usecase

import com.iua.museum.base.BaseUseCase
import com.iua.museum.splash.datasource.entity.AppLoginEntityRequest
import com.iua.museum.splash.datasource.repository.IAppLoginRepository

class AppLoginUseCase(private val repository: IAppLoginRepository): BaseUseCase<AppLoginEntityRequest, AppLoginUseCaseModel>() {

    override suspend fun run(params: AppLoginEntityRequest): AppLoginUseCaseModel =
        repository.callGetAuthToken()

}