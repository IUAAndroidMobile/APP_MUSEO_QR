package com.iua.museum.list.usecase

import com.iua.museum.list.datasource.entity.ItemListResponse

fun ItemListResponse.toUserModel() : ItemListUseCaseModel {
    val dataList = mutableListOf<MuseumItemList>()
    data.forEach {
        dataList.add(
            MuseumItemList(
                publicID = it.publicId,
                title = it.title,
                categoryName = it.category,
                roomName = it.roomName,
                introduction = it.introduction,
                mainImageURL = it.mainImageURL
            )
        )
    }

    return ItemListUseCaseModel(data = dataList)
}