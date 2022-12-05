package com.iua.museum.list.usecase

data class ItemListUseCaseModel(
    val data: List<MuseumItemList>
)

data class MuseumItemList(
    val publicID: String,
    val title: String,
    val categoryName: String,
    val roomName: String,
    val introduction: String,
    val mainImageURL: String
)

