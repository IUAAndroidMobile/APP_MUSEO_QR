package com.tecno_moviles.museum.item_detail.viewModel

import com.tecno_moviles.museum.base.BaseViewModel
import com.tecno_moviles.museum.item_detail.usecase.ItemDetailUseCase

class ItemDetailViewModel(
    private val itemDetailUseCase: ItemDetailUseCase,
    override val bindingDelegate: ItemDetailBindingDelegate,
    private val presenterDelegate: ItemDetailPresenterDelegate = ItemDetailPresenterDelegate(bindingDelegate)
): BaseViewModel(bindingDelegate, presenterDelegate) {




}