package com.iua.museum.item_detail.usecase

import com.iua.museum.item_detail.datasource.entity.ImageGalleryItemResponse
import com.iua.museum.item_detail.datasource.entity.ItemDetailResponse

fun ItemDetailResponse.toUserModel(): ItemDetailUseCaseModel {
    return ItemDetailUseCaseModel(
        id = publicId,
        roomName = roomName,
        title = title,
        introduction = introduction,
        description = description,
        imageGallery = imageGalleryResponse.toUserModel(),
        youToubeLinks = youToubeLinks,
        tags = tags,
        externalLinks = externalLinks,
        lat = 0L,
        long = 0L,
        audioURL = audioURL
    )
}

fun List<ImageGalleryItemResponse>.toUserModel(): List<ImageGalleryItem> {
    val dataList = mutableListOf<ImageGalleryItem>()
    this.forEach {
        dataList.add(
            ImageGalleryItem(
                imageId = it.imageId,
                imageURL = it.imageURL,
                imageDescription = it.imageDescription,
                isMain = it.isMain
            )
        )
    }
    return dataList
}