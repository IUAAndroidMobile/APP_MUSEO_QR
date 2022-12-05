package com.iua.museum.list.datasource.entity

import com.google.gson.annotations.SerializedName

data class ItemListResponse(
    @SerializedName("data") val data: List<ItemResponse>
)

data class ItemResponse(
    @SerializedName("public_id") val publicId: String,
    @SerializedName("title") val title: String,
    @SerializedName("category_name") val category: String,
    @SerializedName("room_name") val roomName: String,
    @SerializedName("introduction") val introduction: String,
    @SerializedName("main_image_url") val mainImageURL: String
)

