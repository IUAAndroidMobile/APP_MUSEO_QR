package com.iua.museum.splash.datasource.repository

import com.iua.museum.splash.datasource.entity.AppLoginEntityRequest
import com.iua.museum.splash.datasource.service.ILoginService
import com.iua.museum.splash.usecase.AppLoginUseCaseModel
import com.iua.museum.splash.usecase.toUserModel

class AppLoginRepository(private val service: ILoginService) : IAppLoginRepository {

    val appUserLoginEntityRequest = AppLoginEntityRequest()

    override suspend fun callGetAuthToken(): AppLoginUseCaseModel = service.getAuthToken(
        appUserLoginEntityRequest.username, appUserLoginEntityRequest.password
    ).toUserModel()

}