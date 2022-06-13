package com.iua.museum.splash.viewModel

import com.iua.museum.base.BasePresenterDelegate

class SplashPresenterDelegate(private val splashBindingDelegate: SplashBindingDelegate): BasePresenterDelegate(splashBindingDelegate) {

    fun checkIsNewUser(showWelcomeScreen: Boolean) {
        splashBindingDelegate.setIsNewUserPostValue(showWelcomeScreen)
    }

}