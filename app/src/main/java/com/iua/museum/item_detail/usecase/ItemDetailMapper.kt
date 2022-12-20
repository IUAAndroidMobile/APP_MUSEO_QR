package com.iua.museum.item_detail.usecase

import com.iua.museum.item_detail.datasource.entity.ImageGalleryItemResponse
import com.iua.museum.item_detail.datasource.entity.ItemDetailResponse

fun ItemDetailResponse.toUserModel(): ItemDetailUseCaseModel {
    return ItemDetailUseCaseModel(
        public_id = item.publicId,
        roomName = item.roomName,
        title = item.title,
        categoryCode = item.categoryCode,
        categoryName = item.categoryName,
        introduction = item.introduction,
        description = item.description,
        imageGallery = item.imageGalleryResponse.toUserModel(),
        youTubeLinks = item.youTubeLinks,
        tags = item.tags,
        externalLinks = item.externalLinks,
        lat = 0L,
        long = 0L,
        audioURL = item.audioURL
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