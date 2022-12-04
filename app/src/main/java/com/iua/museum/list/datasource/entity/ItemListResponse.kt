package com.iua.museum.list.datasource.entity

import com.google.gson.annotations.SerializedName

data class ItemListResponse(
    @SerializedName("data") val data: List<ItemResponse>
)

data class ItemResponse(
    @SerializedName("id") val publicId: Int,
    @SerializedName("category") val category: ItemCategory,
    @SerializedName("room_name") val roomName: String,
    @SerializedName("title") val title: String,
    @SerializedName("introduction") val introduction: String,
    @SerializedName("images") val mainImageURL: List<Images>
)

data class ItemCategory(
    @SerializedName("id") val id: Int,
    @SerializedName("categoryName") val categoryName: String,
    @SerializedName("categoryUrl") val categoryUrl: String
)

data class Images(
    @SerializedName("idImage") val idImage: String,
    @SerializedName("url") val url: String,
    @SerializedName("description") val description: String,
    @SerializedName("main") val main: Boolean
)