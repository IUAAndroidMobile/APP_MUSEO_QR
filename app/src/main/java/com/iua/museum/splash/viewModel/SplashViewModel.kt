package com.iua.museum.splash.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.iua.museum.base.BaseViewModel
import com.iua.museum.base.support.BaseResultWrapper
import com.iua.museum.preferences.IAppPreferencesRepository
import com.iua.museum.splash.datasource.entity.SplashEntityRequest
import com.iua.museum.splash.usecase.ShowWelcomeScreenUseCase
import com.iua.museum.splash.usecase.SplashUseCase
import kotlinx.coroutines.launch

class SplashViewModel(
    private val splashUseCase: SplashUseCase,
    private val showWelcomeScreenUseCase: ShowWelcomeScreenUseCase,
    private val preferencesRepository: IAppPreferencesRepository,
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

    fun saveIsNewUser() {
        viewModelScope.launch {
            preferencesRepository.setIsNewUser(false)
        }
    }

}