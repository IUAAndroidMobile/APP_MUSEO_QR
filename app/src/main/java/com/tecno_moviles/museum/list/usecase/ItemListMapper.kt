package com.tecno_moviles.museum.list.usecase

import com.tecno_moviles.museum.list.datasource.entity.ItemListResponse

fun ItemListResponse.toUserModel() : ItemListUseCaseModel {
    return ItemListUseCaseModel(mutableListOf(MuseumItemList(1, "", "", "", "")))
}