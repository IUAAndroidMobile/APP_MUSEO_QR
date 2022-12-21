package com.iua.museum.base.viewModel

abstract class BasePresenterDelegate(private val bindingDelegate: BaseBindingDelegate) {

    fun showProgressView() {
        bindingDelegate.showProgressViewPostValue()
    }

    fun hideProgressView() {
        bindingDelegate.hideProgressViewPostValue()
    }

    fun showServerError() {
        bindingDelegate.showServerErrorPostValue()
    }

}