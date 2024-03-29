package com.iua.museum.list.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.iua.museum.base.viewModel.BaseViewModel
import com.iua.museum.base.support.BaseResultWrapper
import com.iua.museum.list.datasource.entity.ItemListRequest
import com.iua.museum.list.usecase.ItemListUseCase
import kotlinx.coroutines.launch

class ItemListViewModel(
    private val itemListUseCase: ItemListUseCase,
    val itemListBindingDelegate: ItemListBindingDelegate,
    private val presenterDelegate: ItemListPresenterDelegate = ItemListPresenterDelegate(itemListBindingDelegate)
): BaseViewModel(itemListBindingDelegate, presenterDelegate) {

    fun callGetAllItems() {
        presenterDelegate.showProgressView()
        viewModelScope.launch {
            appPreferencesRepository.getTokenU()?.let { token ->
                when(val response = itemListUseCase.invoke(ItemListRequest("Bearer $token"))) {
                    is BaseResultWrapper.ApiError -> {
                        presenterDelegate.showServerError()
                    }
                    is BaseResultWrapper.ApiSuccess -> {
                        presenterDelegate.showSuccessList(response.value)
                    }
                }
            } ?: run {
                //Should navigate to splash.
            }
        }
    }

}