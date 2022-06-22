package com.iua.museum.list.datasource.service

import com.iua.museum.list.datasource.entity.ItemListResponse
import retrofit2.http.GET

interface IItemListService {

    //@GET("api/items")
    @GET("/v1/c9df34e0-55b8-44d6-a6df-0fc31f77e7d7")
    suspend fun getItemList(): ItemListResponse
}