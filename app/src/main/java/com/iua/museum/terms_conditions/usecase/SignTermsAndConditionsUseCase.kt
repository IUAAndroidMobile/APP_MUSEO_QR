package com.iua.museum.terms_conditions.usecase

import com.iua.museum.base.BaseUseCase
import com.iua.museum.preferences.IAppPreferencesRepository
import com.iua.museum.terms_conditions.datasource.entity.TermsAndConditionsRequest

class SignTermsAndConditionsUseCase (private val repository: IAppPreferencesRepository): BaseUseCase<TermsAndConditionsRequest, Unit>() {

    override suspend fun run(params: TermsAndConditionsRequest) {
        repository.setAcceptTermsAndConditions(params.signTermsAndConditions)
    }
}