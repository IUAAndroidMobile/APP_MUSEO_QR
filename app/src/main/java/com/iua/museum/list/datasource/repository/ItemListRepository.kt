package com.iua.museum.list.datasource.repository

import com.iua.museum.list.datasource.service.IItemListService
import com.iua.museum.list.usecase.ItemListUseCaseModel
import com.iua.museum.list.usecase.toUserModel

class ItemListRepository(private val service: IItemListService): IItemListRepository {

    @Throws(Exception::class)
    override suspend fun callGetAllItems(token: String): ItemListUseCaseModel {
        return service.getItemList(token).toUserModel()
    }

}