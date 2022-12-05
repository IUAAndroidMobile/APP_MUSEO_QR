package com.iua.museum.item_detail.datasource.entity

import com.google.gson.annotations.SerializedName

data class ItemDetailResponse(
    @SerializedName("item") val item: ItemDetailResponseContent
)

data class ItemDetailResponseContent(
    @SerializedName("public_id") val publicId: String,
    @SerializedName("room_name") val roomName: String,
    @SerializedName("title") val title: String,
    @SerializedName("category_code") val categoryCode: String,
    @SerializedName("category_name") val categoryName: String,
    @SerializedName("category_url") val categoryUrl: String,
    @SerializedName("introduction") val introduction: String,
    @SerializedName("description") val description: String,
    @SerializedName("image_gallery") val imageGalleryResponse: List<ImageGalleryItemResponse>,
    @SerializedName("youtube_links") val youToubeLinks: List<String>,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("external_links") val externalLinks: List<String>,
    @SerializedName("lat") val lat: String,
    @SerializedName("long") val long: String,
    @SerializedName("audio_url") val audioURL: String,
)

data class ItemCategory(
    @SerializedName("id") val id: Int,
    @SerializedName("categoryName") val categoryName: String,
    @SerializedName("categoryUrl") val categoryUrl: String
)

data class ImageGalleryItemResponse(
    @SerializedName("image_id") val imageId: String,
    @SerializedName("image_description") val imageDescription: String,
    @SerializedName("image_url") val imageURL: String,
    @SerializedName("is_main") val isMain: Boolean
)
