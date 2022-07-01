package com.iua.museum.item_detail.view.image_gallery

import android.os.Parcelable
import com.iua.museum.item_detail.usecase.ImageGalleryItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageGalleryViewInput(
    val imageList: List<ImageGalleryItem>
): Parcelable