package com.iua.museum.splash.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.iua.museum.base.BaseBindingDelegate

class SplashBindingDelegate: BaseBindingDelegate() {

    //Region show welcome screen
    private val _setIsNewUserLiveData = MutableLiveData<Boolean>()
    val setIsNewUser : LiveData<Boolean> get() = _setIsNewUserLiveData
    fun setIsNewUserPostValue(isNewUser: Boolean) {
        _setIsNewUserLiveData.value = isNewUser
    }
    //End region welcome screen

}