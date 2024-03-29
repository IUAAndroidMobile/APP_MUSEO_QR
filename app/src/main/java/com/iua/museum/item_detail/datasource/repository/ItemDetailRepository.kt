package com.iua.museum.item_detail.datasource.repository

import com.iua.museum.item_detail.datasource.service.IItemDetailService
import com.iua.museum.item_detail.usecase.ItemDetailUseCaseModel
import com.iua.museum.item_detail.usecase.toUserModel

class ItemDetailRepository(private val service: IItemDetailService): IItemDetailRepository {

    override suspend fun getItemDetailById(token: String, publicId: String): ItemDetailUseCaseModel =
        service.getItemById(token, publicId).toUserModel()
}