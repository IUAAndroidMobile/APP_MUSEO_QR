package com.iua.museum.list.datasource.repository

import com.iua.museum.list.usecase.ItemListUseCaseModel

interface IItemListRepository {

    @Throws(Exception::class)
    suspend fun callGetAllItems(token: String): ItemListUseCaseModel
}