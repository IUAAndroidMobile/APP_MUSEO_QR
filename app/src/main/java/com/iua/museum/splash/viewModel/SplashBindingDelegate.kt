package com.iua.museum.splash.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.iua.museum.base.viewModel.BaseBindingDelegate

class SplashBindingDelegate: BaseBindingDelegate() {

    //Region save user Token
    private val _userTokenLiveData = MutableLiveData<String>()
    val setUserToken: LiveData<String> get() = _userTokenLiveData
    fun setUserTokenPostValue(userToken: String) {
        _userTokenLiveData.postValue(userToken)
    }

    //End region save user token

    //Region show Terms and Condition
    private val _setShowTermsAndConditionLiveData = MutableLiveData<Boolean>()
    val setTermsAndCondition: LiveData<Boolean> get() = _setShowTermsAndConditionLiveData
    fun setTermsAndConditionPostValue(termsAndCondition: Boolean) {
        _setShowTermsAndConditionLiveData.value = termsAndCondition
    }
    //End region Terms and Condition

    //Region show welcome screen
    private val _setIsNewUserLiveData = MutableLiveData<Boolean>()
    val setIsNewUser : LiveData<Boolean> get() = _setIsNewUserLiveData
    fun setIsNewUserPostValue(isNewUser: Boolean) {
        _setIsNewUserLiveData.value = isNewUser
    }
    //End region welcome screen

}