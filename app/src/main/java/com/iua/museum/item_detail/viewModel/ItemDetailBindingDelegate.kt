package com.iua.museum.item_detail.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.iua.museum.base.viewModel.BaseBindingDelegate
import com.iua.museum.item_detail.usecase.ItemDetailUseCaseModel

class ItemDetailBindingDelegate: BaseBindingDelegate() {

    //Region Item List
    private val _setItemDetail = MutableLiveData<ItemDetailUseCaseModel>()
    val setItemDetail: LiveData<ItemDetailUseCaseModel> get() = _setItemDetail
    fun setItemDetailPostValue(itemDetail: ItemDetailUseCaseModel) {
        _setItemDetail.postValue(itemDetail)
    }
    //End region item List


}