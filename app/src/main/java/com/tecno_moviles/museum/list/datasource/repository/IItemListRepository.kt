package com.tecno_moviles.museum.list.datasource.repository

import com.tecno_moviles.museum.list.usecase.ItemListUseCaseModel

interface IItemListRepository {

    suspend fun callGetAllItems(): ItemListUseCaseModel
}