package com.iua.museum.list.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.iua.museum.base.BaseBindingDelegate
import com.iua.museum.list.usecase.ItemListUseCaseModel

class ItemListBindingDelegate: BaseBindingDelegate() {
    //region list of items
    private val _setItemList = MutableLiveData<ItemListUseCaseModel>()
    val setItemList: LiveData<ItemListUseCaseModel> get() = _setItemList
    fun setItemListPostValue(itemList: ItemListUseCaseModel) {
        _setItemList.value = itemList
    }
    //end region list of items
}