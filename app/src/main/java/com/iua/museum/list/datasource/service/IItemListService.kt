package com.iua.museum.list.datasource.service

import com.iua.museum.list.datasource.entity.ItemListResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface IItemListService {

    @GET("api/v1/items")
    //@GET("https://mocki.io/v1/7ecb4f96-38c8-4158-bcd4-1faf849b2d86")
    suspend fun getItemList(@Header("Authorization") token: String): ItemListResponse
}