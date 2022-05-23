package com.tecno_moviles.museum.base

import androidx.lifecycle.ViewModel

open class BaseViewModel(
    open val bindingDelegate: BaseBindingDelegate,
    private val presentationDelegate: BasePresenterDelegate
) : ViewModel() {


    fun callLogout() {
        //TODO: Expire authorization here if necessary.
    }

}