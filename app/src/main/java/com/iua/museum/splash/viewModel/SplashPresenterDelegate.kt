package com.iua.museum.splash.viewModel

import com.iua.museum.base.viewModel.BasePresenterDelegate

class SplashPresenterDelegate(private val splashBindingDelegate: SplashBindingDelegate): BasePresenterDelegate(splashBindingDelegate) {

    fun setUserToken(userToken: String) {
        splashBindingDelegate.setUserTokenPostValue(userToken)
    }

    fun checkShowTermsAndConditions(showTermsAndConditions: Boolean) {
        splashBindingDelegate.setTermsAndConditionPostValue(showTermsAndConditions)
    }

    fun checkIsNewUser(showWelcomeScreen: Boolean) {
        splashBindingDelegate.setIsNewUserPostValue(showWelcomeScreen)
    }

}