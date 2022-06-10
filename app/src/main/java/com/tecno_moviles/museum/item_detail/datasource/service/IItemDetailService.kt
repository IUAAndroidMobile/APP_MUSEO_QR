package com.tecno_moviles.museum.item_detail.datasource.service

import com.tecno_moviles.museum.item_detail.datasource.entity.ItemDetailResponse
import retrofit2.http.GET

interface IItemDetailService {

    @GET("api/items/id")
    suspend fun getItemById(): ItemDetailResponse
}