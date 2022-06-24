package com.iua.museum.item_detail.viewModel

import com.iua.museum.base.BasePresenterDelegate
import com.iua.museum.item_detail.usecase.ItemDetailUseCaseModel

class ItemDetailPresenterDelegate(private val itemDetailBindingDelegate: ItemDetailBindingDelegate): BasePresenterDelegate(itemDetailBindingDelegate) {

    fun showItemDetail(data: ItemDetailUseCaseModel) {
        itemDetailBindingDelegate.setItemDetailPostValue(data)
        hideProgressView()
    }

}