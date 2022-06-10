package com.tecno_moviles.museum.item_detail.datasource.repository

import com.tecno_moviles.museum.item_detail.usecase.ItemDetailUseCaseModel

interface IItemDetailRepository {

    suspend fun getItemDetailById(): ItemDetailUseCaseModel
}