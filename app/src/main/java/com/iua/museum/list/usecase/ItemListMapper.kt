package com.iua.museum.list.usecase

import com.iua.museum.list.datasource.entity.ItemListResponse

fun ItemListResponse.toUserModel() : ItemListUseCaseModel {
    return ItemListUseCaseModel(mutableListOf(MuseumItemList(1, "", "", "", "")))
}