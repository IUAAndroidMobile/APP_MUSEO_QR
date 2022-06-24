package com.iua.museum.item_detail.usecase

data class ItemDetailUseCaseModel(
    val id: Int,
    val roomName: String,
    val title: String,
    val introduction: String,
    val description: String,
    val imageGallery: List<ImageGalleryItem>,
    val youToubeLinks: String,
    val tags: String,
    val externalLinks: String,
    val lat: Long,
    val long: Long,
    val audioURL: String
)

data class ImageGalleryItem(
    val imageId: Int,
    val imageURL: String,
    val imageDescription: String,
    val isMain: Boolean
)