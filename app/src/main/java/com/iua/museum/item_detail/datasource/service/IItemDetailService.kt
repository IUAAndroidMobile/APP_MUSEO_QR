package com.iua.museum.item_detail.datasource.service

import com.iua.museum.item_detail.datasource.entity.ItemDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface IItemDetailService {

    @GET("api/items/{id}")
    suspend fun getItemById(@Path("id") id: Int): ItemDetailResponse
}