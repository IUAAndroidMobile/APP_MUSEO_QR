package com.iua.museum.splash.usecase

import com.iua.museum.base.BaseUseCase
import com.iua.museum.preferences.IAppPreferencesRepository
import com.iua.museum.splash.datasource.entity.AppLoginEntityRequest

class ShowTermsAndConditionsScreenUseCase(private val repository: IAppPreferencesRepository):
    BaseUseCase<AppLoginEntityRequest, Boolean>() {

    override suspend fun run(params: AppLoginEntityRequest): Boolean = repository.getAcceptTermsAndConditions()
}