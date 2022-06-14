package com.iua.museum.item_detail.usecase

import com.iua.museum.base.BaseUseCase
import com.iua.museum.item_detail.datasource.entity.ItemDetailRequest
import com.iua.museum.item_detail.datasource.repository.IItemDetailRepository

class ItemDetailUseCase(private val repository: IItemDetailRepository): BaseUseCase<ItemDetailRequest, ItemDetailUseCaseModel>() {

    override suspend fun run(params: ItemDetailRequest): ItemDetailUseCaseModel {
        TODO("Not yet implemented")
    }
}