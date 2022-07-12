package com.iua.museum.terms_conditions.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.iua.museum.base.viewModel.BaseViewModel
import com.iua.museum.base.support.BaseResultWrapper
import com.iua.museum.splash.datasource.entity.SplashEntityRequest
import com.iua.museum.splash.usecase.ShowWelcomeScreenUseCase
import com.iua.museum.terms_conditions.datasource.entity.TermsAndConditionsRequest
import com.iua.museum.terms_conditions.usecase.SignTermsAndConditionsUseCase
import kotlinx.coroutines.launch

class TermsAndConditionsViewModel(
    private val signTermsAndConditionsUseCase: SignTermsAndConditionsUseCase,
    private val showWelcomeScreenUseCase: ShowWelcomeScreenUseCase,
    override val bindingDelegate: TermsAndConditionsBindingDelegate,
    private val presenterDelegate: TermsAndConditionsPresenterDelegate = TermsAndConditionsPresenterDelegate(bindingDelegate)
): BaseViewModel(bindingDelegate, presenterDelegate) {

    fun signTermsAndConditions(signTermsAndConditions: Boolean) {
        viewModelScope.launch {
            when(val response = signTermsAndConditionsUseCase.invoke(TermsAndConditionsRequest(signTermsAndConditions))) {
                is BaseResultWrapper.ApiError -> {
                    Log.d("ERROR", response.error.toString())
                }
                is BaseResultWrapper.ApiSuccess -> {
                    presenterDelegate.termsAndConditionsSigned(signTermsAndConditions)
                }
            }
        }
    }

    fun isNewUser() {
        viewModelScope.launch {
            when(val response = showWelcomeScreenUseCase.invoke(SplashEntityRequest())) {
                is BaseResultWrapper.ApiError -> {
                    Log.d("ERROR", response.error.toString())
                }
                is BaseResultWrapper.ApiSuccess -> {
                    presenterDelegate.checkIsNewUser(response.value)
                }
            }
        }
    }

}