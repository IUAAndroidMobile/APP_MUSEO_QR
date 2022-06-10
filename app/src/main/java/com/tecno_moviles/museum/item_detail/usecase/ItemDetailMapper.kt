package com.tecno_moviles.museum.item_detail.usecase

import com.tecno_moviles.museum.item_detail.datasource.entity.ItemDetailResponse

fun ItemDetailResponse.toUserModel(): ItemDetailUseCaseModel {
    return ItemDetailUseCaseModel(1)
}