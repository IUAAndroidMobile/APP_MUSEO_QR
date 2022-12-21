package com.iua.museum.base.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class BaseBindingDelegate {
    //Region Generic operations
    //Region show progress view
    private val _showProgressView = MutableLiveData<Unit>()
    val showProgressView: LiveData<Unit> get() = _showProgressView
    fun showProgressViewPostValue() {
        _showProgressView.postValue(Unit)
    }
    //End show progress view
    //Region hide progress view
    private val _hideProgressView = MutableLiveData<Unit>()
    val hideProgressView: LiveData<Unit> get() = _hideProgressView
    fun hideProgressViewPostValue() {
        _hideProgressView.postValue(Unit)
    }
    //End hide progress view
    //Show server Error
    private val _showServerError = MutableLiveData<Unit>()
    val showServerErrorLiveData: LiveData<Unit> get() = _showServerError
    fun showServerErrorPostValue() {
        _showServerError.postValue(Unit)
    }
    //End Region show server error
    //End Region Generic operations
}