package com.iua.museum.base

abstract class BasePresenterDelegate(private val bindingDelegate: BaseBindingDelegate) {

    fun showProgressView() {
        bindingDelegate.showProgressViewPostValue()
    }

    fun hideProgressView() {
        bindingDelegate.hideProgressViewPostValue()
    }

}