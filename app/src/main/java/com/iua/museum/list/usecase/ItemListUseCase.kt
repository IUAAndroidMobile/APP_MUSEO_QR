package com.iua.museum.list.usecase

import com.iua.museum.base.BaseUseCase
import com.iua.museum.list.datasource.entity.ItemListRequest
import com.iua.museum.list.datasource.repository.IItemListRepository

class ItemListUseCase(private val repository: IItemListRepository): BaseUseCase<ItemListRequest, ItemListUseCaseModel>() {

    override suspend fun run(params: ItemListRequest): ItemListUseCaseModel {
        return repository.callGetAllItems(params.token)
    }
}