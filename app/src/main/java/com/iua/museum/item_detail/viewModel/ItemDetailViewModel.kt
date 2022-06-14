package com.iua.museum.item_detail.viewModel

import com.iua.museum.base.BaseViewModel
import com.iua.museum.item_detail.usecase.ItemDetailUseCase

class ItemDetailViewModel(
    private val itemDetailUseCase: ItemDetailUseCase,
    override val bindingDelegate: ItemDetailBindingDelegate,
    private val presenterDelegate: ItemDetailPresenterDelegate = ItemDetailPresenterDelegate(bindingDelegate)
): BaseViewModel(bindingDelegate, presenterDelegate) {




}