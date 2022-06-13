package com.iua.museum.list.datasource.repository

import com.iua.museum.list.usecase.ItemListUseCaseModel

interface IItemListRepository {

    suspend fun callGetAllItems(): ItemListUseCaseModel
}