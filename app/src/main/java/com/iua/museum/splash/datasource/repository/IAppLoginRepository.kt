package com.iua.museum.splash.datasource.repository

import com.iua.museum.splash.usecase.AppLoginUseCaseModel

interface IAppLoginRepository {

    suspend fun callGetAuthToken(): AppLoginUseCaseModel
}