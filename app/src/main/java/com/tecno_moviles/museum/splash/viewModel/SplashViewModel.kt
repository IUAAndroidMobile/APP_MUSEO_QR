package com.tecno_moviles.museum.splash.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.tecno_moviles.museum.base.BaseViewModel
import com.tecno_moviles.museum.base.support.BaseResultWrapper
import com.tecno_moviles.museum.splash.datasource.entity.SplashEntityRequest
import com.tecno_moviles.museum.splash.usecase.SplashUseCase
import kotlinx.coroutines.launch

class SplashViewModel(
    private val splashUseCase: SplashUseCase,
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

}