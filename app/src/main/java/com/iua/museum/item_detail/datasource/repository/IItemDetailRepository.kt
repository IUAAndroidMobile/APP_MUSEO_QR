package com.iua.museum.item_detail.datasource.repository

import com.iua.museum.item_detail.usecase.ItemDetailUseCaseModel

interface IItemDetailRepository {

    suspend fun getItemDetailById(token: String, publicId: String): ItemDetailUseCaseModel
}