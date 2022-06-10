package com.tecno_moviles.museum.item_detail.usecase

import com.tecno_moviles.museum.base.BaseUseCase
import com.tecno_moviles.museum.item_detail.datasource.entity.ItemDetailRequest
import com.tecno_moviles.museum.item_detail.datasource.repository.IItemDetailRepository

class ItemDetailUseCase(private val repository: IItemDetailRepository): BaseUseCase<ItemDetailRequest, ItemDetailUseCaseModel>() {

    override suspend fun run(params: ItemDetailRequest): ItemDetailUseCaseModel {
        TODO("Not yet implemented")
    }
}