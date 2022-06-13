package com.iua.museum.list.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.iua.museum.base.BaseViewModel
import com.iua.museum.base.support.BaseResultWrapper
import com.iua.museum.list.datasource.entity.ItemListRequest
import com.iua.museum.list.usecase.ItemListUseCase
import kotlinx.coroutines.launch

class ItemListViewModel(
    private val itemListUseCase: ItemListUseCase,
    override val bindingDelegate: ItemListBindingDelegate,
    private val presenterDelegate: ItemListPresenterDelegate = ItemListPresenterDelegate(bindingDelegate)
): BaseViewModel(bindingDelegate, presenterDelegate) {

    fun callGetAllItems() {
        viewModelScope.launch {
            when(val response = itemListUseCase.invoke(ItemListRequest())) {
                is BaseResultWrapper.ApiError -> {
                    // We had an error
                    Log.d("ERROR", response.error.toString())
                }
                is BaseResultWrapper.ApiSuccess -> {
                    presenterDelegate.showSuccessList(response.value)
                }
            }
        }
    }

}