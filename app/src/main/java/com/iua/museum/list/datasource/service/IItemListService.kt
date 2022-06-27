package com.iua.museum.list.datasource.service

import com.iua.museum.list.datasource.entity.ItemListResponse
import retrofit2.http.GET

interface IItemListService {

    //@GET("api/items")
    @GET("/v1/7ecb4f96-38c8-4158-bcd4-1faf849b2d86")
    suspend fun getItemList(): ItemListResponse
}