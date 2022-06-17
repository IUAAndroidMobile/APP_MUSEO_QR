package com.iua.museum.list.usecase

import android.util.Log
import com.iua.museum.base.BaseUseCase
import com.iua.museum.list.datasource.entity.ItemListRequest
import com.iua.museum.list.datasource.repository.IItemListRepository

class ItemListUseCase(private val repository: IItemListRepository): BaseUseCase<ItemListRequest, ItemListUseCaseModel>() {

    override suspend fun run(params: ItemListRequest): ItemListUseCaseModel {
        Log.d("ITEM_LIST_USE_CASE", repository.toString())
        return repository.callGetAllItems()
    }
}