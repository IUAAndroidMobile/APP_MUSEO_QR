package com.iua.museum.splash.usecase

import com.iua.museum.base.BaseUseCase
import com.iua.museum.preferences.IAppPreferencesRepository
import com.iua.museum.splash.datasource.entity.SplashEntityRequest

class ShowTermsAndConditionsScreenUseCase(private val repository: IAppPreferencesRepository):
    BaseUseCase<SplashEntityRequest, Boolean>() {

    override suspend fun run(params: SplashEntityRequest): Boolean = repository.getAcceptTermsAndConditions()
}