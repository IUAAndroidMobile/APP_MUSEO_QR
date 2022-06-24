package com.iua.museum.item_detail.datasource.entity

import com.google.gson.annotations.SerializedName

data class ItemDetailResponse(
    @SerializedName("public_id") val publicId: Int,
    @SerializedName("room_name") val roomName: String,
    @SerializedName("title") val title: String,
    @SerializedName("introduction") val introduction: String,
    @SerializedName("description") val description: String,
    @SerializedName("image_gallery") val imageGalleryResponse: List<ImageGalleryItemResponse>,
    @SerializedName("youtube_links") val youToubeLinks: String,
    @SerializedName("tags") val tags: String,
    @SerializedName("external_links") val externalLinks: String,
    @SerializedName("lat") val lat: Long,
    @SerializedName("long") val long: Long,
    @SerializedName("audio_url") val audioURL: String

)

data class ImageGalleryItemResponse(
    @SerializedName("image_id") val imageId: Int,
    @SerializedName("image_url") val imageURL: String,
    @SerializedName("image_description") val imageDescription: String,
    @SerializedName("is_main") val isMain: Boolean
)
