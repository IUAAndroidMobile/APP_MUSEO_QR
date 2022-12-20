package com.iua.museum.item_detail.usecase

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ItemDetailUseCaseModel(
    val public_id: String,
    val roomName: String,
    val title: String,
    val categoryCode: String,
    val categoryName: String,
    val introduction: String,
    val description: String,
    val imageGallery: List<ImageGalleryItem>,
    val youTubeLinks: List<String>,
    val tags: List<String>,
    val externalLinks: List<String>,
    val lat: Long,
    val long: Long,
    val audioURL: String
)

@Parcelize
data class ImageGalleryItem(
    val imageId: String,
    val imageURL: String,
    val imageDescription: String,
    val isMain: Boolean
): Parcelable