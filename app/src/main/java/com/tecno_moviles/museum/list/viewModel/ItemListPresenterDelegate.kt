package com.tecno_moviles.museum.list.viewModel

import com.tecno_moviles.museum.base.BasePresenterDelegate
import com.tecno_moviles.museum.list.usecase.ItemListUseCaseModel

class ItemListPresenterDelegate(private val itemListBindingDelegate: ItemListBindingDelegate): BasePresenterDelegate(itemListBindingDelegate) {

    fun showSuccessList(data: ItemListUseCaseModel) {
        itemListBindingDelegate.setItemListPostValue(data)
    }

}