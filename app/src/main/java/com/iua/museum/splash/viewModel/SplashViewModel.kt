package com.iua.museum.splash.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.iua.museum.base.BaseViewModel
import com.iua.museum.base.support.BaseResultWrapper
import com.iua.museum.preferences.IAppPreferencesRepository
import com.iua.museum.splash.datasource.entity.SplashEntityRequest
import com.iua.museum.splash.usecase.ShowTermsAndConditionsScreenUseCase
import com.iua.museum.splash.usecase.ShowWelcomeScreenUseCase
import com.iua.museum.splash.usecase.SplashUseCase
import kotlinx.coroutines.launch

class SplashViewModel(
    private val splashUseCase: SplashUseCase,
    private val showTermsAndConditionsScreenUseCase: ShowTermsAndConditionsScreenUseCase,
    private val showWelcomeScreenUseCase: ShowWelcomeScreenUseCase,
    override val bindingDelegate: SplashBindingDelegate,
    private val presenterDelegate: SplashPresenterDelegate = SplashPresenterDelegate(bindingDelegate)
): BaseViewModel(bindingDelegate, presenterDelegate) {

    fun callGetAuthToken() {
        viewModelScope.launch {
            when(val response = splashUseCase.invoke(SplashEntityRequest())) {
                is BaseResultWrapper.ApiError -> {
                    Log.d("ERROR", response.error.toString())
                }
                is BaseResultWrapper.ApiSuccess -> {
                    //presenterDelegate
                }
            }
        }
    }

    fun shouldShowTermsAndConditions() {
        viewModelScope.launch {
            when(val response = showTermsAndConditionsScreenUseCase.invoke(SplashEntityRequest())) {
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