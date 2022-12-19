package com.iua.museum.splash.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.iua.museum.base.viewModel.BaseViewModel
import com.iua.museum.base.support.BaseResultWrapper
import com.iua.museum.splash.datasource.entity.AppLoginEntityRequest
import com.iua.museum.splash.usecase.ShowTermsAndConditionsScreenUseCase
import com.iua.museum.splash.usecase.ShowWelcomeScreenUseCase
import com.iua.museum.splash.usecase.AppLoginUseCase
import kotlinx.coroutines.launch

class SplashViewModel(
    private val appLoginUseCase: AppLoginUseCase,
    private val showTermsAndConditionsScreenUseCase: ShowTermsAndConditionsScreenUseCase,
    private val showWelcomeScreenUseCase: ShowWelcomeScreenUseCase,
    val splashBindingDelegate: SplashBindingDelegate,
    private val presenterDelegate: SplashPresenterDelegate = SplashPresenterDelegate(splashBindingDelegate)
): BaseViewModel(splashBindingDelegate, presenterDelegate) {

    fun callGetAuthToken() {
        viewModelScope.launch {
            when(val response = appLoginUseCase.invoke(AppLoginEntityRequest())) {
                is BaseResultWrapper.ApiError -> {
                    Log.d("ERROR", response.error.toString())
                    presenterDelegate.setUserToken(response.error.errorStatus.name)
                }
                is BaseResultWrapper.ApiSuccess -> {
                    appPreferencesRepository.setTokenU(response.value.token)
                    presenterDelegate.setUserToken(response.value.token)
                }
            }
        }
    }

    fun shouldShowTermsAndConditions() {
        viewModelScope.launch {
            when(val response = showTermsAndConditionsScreenUseCase.invoke(AppLoginEntityRequest())) {
                is BaseResultWrapper.ApiError -> {
                    Log.d("ERROR", response.error.toString())
                }
                is BaseResultWrapper.ApiSuccess -> {
                    presenterDelegate.checkShowTermsAndConditions(response.value)
                }
            }
        }
    }

    fun isNewUser() {
        viewModelScope.launch {
            when(val response = showWelcomeScreenUseCase.invoke(AppLoginEntityRequest())) {
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