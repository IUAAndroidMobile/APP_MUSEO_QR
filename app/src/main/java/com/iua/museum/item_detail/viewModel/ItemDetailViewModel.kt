package com.iua.museum.item_detail.viewModel

import androidx.lifecycle.viewModelScope
import com.iua.museum.base.viewModel.BaseViewModel
import com.iua.museum.base.support.BaseResultWrapper
import com.iua.museum.item_detail.datasource.entity.ItemDetailRequest
import com.iua.museum.item_detail.usecase.ItemDetailUseCase
import kotlinx.coroutines.launch

class ItemDetailViewModel(
    private val itemDetailUseCase: ItemDetailUseCase,
    override val bindingDelegate: ItemDetailBindingDelegate,
    private val presenterDelegate: ItemDetailPresenterDelegate = ItemDetailPresenterDelegate(bindingDelegate)
): BaseViewModel(bindingDelegate, presenterDelegate) {

    fun callGetItemById(publicID: String) {
        presenterDelegate.showProgressView()
        viewModelScope.launch {
            appPreferencesRepository.getTokenU()?.let { token ->
                when (val response = itemDetailUseCase.invoke(ItemDetailRequest("Bearer $token", publicID))) {
                    is BaseResultWrapper.ApiError -> {
                        presenterDelegate.hideProgressView()
                    }
                    is BaseResultWrapper.ApiSuccess -> {
                        presenterDelegate.showItemDetail(response.value)
                    }
                }
            } ?: run {
                //Should navigate to splash.
            }
        }
    }


}