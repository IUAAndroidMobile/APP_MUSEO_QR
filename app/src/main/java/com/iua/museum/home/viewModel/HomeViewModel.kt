package com.iua.museum.home.viewModel

import com.iua.museum.base.viewModel.BaseViewModel

class HomeViewModel(
    val homeBindingDelegate: HomeBindingDelegate,
    private val presenterDelegate: HomePresenterDelegate = HomePresenterDelegate(homeBindingDelegate)
) : BaseViewModel(homeBindingDelegate, presenterDelegate) {


}