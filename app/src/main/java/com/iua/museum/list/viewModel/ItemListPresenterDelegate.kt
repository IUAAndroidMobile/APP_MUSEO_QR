package com.iua.museum.list.viewModel

import com.iua.museum.base.BasePresenterDelegate
import com.iua.museum.list.usecase.ItemListUseCaseModel

class ItemListPresenterDelegate(private val itemListBindingDelegate: ItemListBindingDelegate): BasePresenterDelegate(itemListBindingDelegate) {

    fun showSuccessList(data: ItemListUseCaseModel) {
        itemListBindingDelegate.setItemListPostValue(data)
    }
}