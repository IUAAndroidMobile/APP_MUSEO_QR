package com.iua.museum.list.usecase

import com.iua.museum.list.datasource.entity.ItemListResponse

fun ItemListResponse.toUserModel() : ItemListUseCaseModel {
    val dataList = mutableListOf<MuseumItemList>()
    data.forEach {
        dataList.add(
            MuseumItemList(
                id = it.publicId,
                roomName = it.roomName,
                title = it.title,
                introduction = it.introduction,
                mainImageURL = it.mainImageURL
            )
        )
    }

    return ItemListUseCaseModel(data = dataList)
}