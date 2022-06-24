package com.iua.museum.item_detail.viewModel

import androidx.lifecycle.viewModelScope
import com.iua.museum.base.BaseViewModel
import com.iua.museum.base.support.BaseResultWrapper
import com.iua.museum.item_detail.datasource.entity.ItemDetailRequest
import com.iua.museum.item_detail.usecase.ItemDetailUseCase
import kotlinx.coroutines.launch

class ItemDetailViewModel(
    private val itemDetailUseCase: ItemDetailUseCase,
    override val bindingDelegate: ItemDetailBindingDelegate,
    private val presenterDelegate: ItemDetailPresenterDelegate = ItemDetailPresenterDelegate(bindingDelegate)
): BaseViewModel(bindingDelegate, presenterDelegate) {


    fun callGetItemById(publicID: Int) {
        presenterDelegate.showProgressView()
        viewModelScope.launch {
            when(val response = itemDetailUseCase.invoke(ItemDetailRequest(publicID))) {
                is BaseResultWrapper.ApiError -> {
                    presenterDelegate.hideProgressView()
                }
                is BaseResultWrapper.ApiSuccess -> {
                    presenterDelegate.showItemDetail(response.value)
                }
            }
        }
    }


}