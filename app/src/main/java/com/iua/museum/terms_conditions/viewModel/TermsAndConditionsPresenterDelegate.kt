package com.iua.museum.terms_conditions.viewModel

import com.iua.museum.base.viewModel.BasePresenterDelegate

class TermsAndConditionsPresenterDelegate(private val termsAndConditionsBindingDelegate: TermsAndConditionsBindingDelegate): BasePresenterDelegate(termsAndConditionsBindingDelegate) {

    fun termsAndConditionsSigned(termsAndConditionsSigned: Boolean) {
        termsAndConditionsBindingDelegate.setTermsAndConditionsSignedPostValue(termsAndConditionsSigned)
    }

    fun checkIsNewUser(showWelcomeScreen: Boolean) {
        termsAndConditionsBindingDelegate.setIsNewUserPostValue(showWelcomeScreen)
    }

}