package com.tecno_moviles.museum.list.datasource.repository

import com.tecno_moviles.museum.list.datasource.service.IItemListService
import com.tecno_moviles.museum.list.usecase.ItemListUseCaseModel
import com.tecno_moviles.museum.list.usecase.toUserModel

class ItemListRepository(private val service: IItemListService): IItemListRepository {

    override suspend fun callGetAllItems(): ItemListUseCaseModel =
        service.getItemList().toUserModel()

}