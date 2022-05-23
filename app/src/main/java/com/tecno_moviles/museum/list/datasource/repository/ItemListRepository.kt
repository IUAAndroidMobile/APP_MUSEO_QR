package com.tecno_moviles.museum.list.datasource.repository

import com.tecno_moviles.museum.list.datasource.service.IItemListService
import com.tecno_moviles.museum.list.usecase.ItemListUseCaseModel

class ItemListRepository(private val iItemListService: IItemListService): IItemListRepository {

    override suspend fun callGetAllItems(): ItemListUseCaseModel {
    }
}