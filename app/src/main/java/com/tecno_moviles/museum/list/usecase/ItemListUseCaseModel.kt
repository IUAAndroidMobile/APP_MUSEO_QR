package com.tecno_moviles.museum.list.usecase

data class ItemListUseCaseModel(
    val data: List<MuseumItemList>
)

data class MuseumItemList(
    val id: Int,
    val roomName: String,
    val title: String,
    val introduction: String,
    val mainImageURL: String
)

