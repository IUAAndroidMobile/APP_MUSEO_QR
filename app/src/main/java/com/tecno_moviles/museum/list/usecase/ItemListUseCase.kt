package com.tecno_moviles.museum.list.usecase

import com.tecno_moviles.museum.base.BaseUseCase
import com.tecno_moviles.museum.list.datasource.entity.ItemListRequest
import com.tecno_moviles.museum.list.datasource.repository.IItemListRepository

class ItemListUseCase(private val repository: IItemListRepository): BaseUseCase<ItemListRequest, ItemListUseCaseModel>() {

    override suspend fun run(params: ItemListRequest): ItemListUseCaseModel =
        repository.callGetAllItems()
}