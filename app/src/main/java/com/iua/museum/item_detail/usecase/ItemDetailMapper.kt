package com.iua.museum.item_detail.usecase

import com.iua.museum.item_detail.datasource.entity.ItemDetailResponse

fun ItemDetailResponse.toUserModel(): ItemDetailUseCaseModel {
    return ItemDetailUseCaseModel(1)
}