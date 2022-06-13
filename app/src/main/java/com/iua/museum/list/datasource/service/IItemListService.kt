package com.iua.museum.list.datasource.service

import com.iua.museum.list.datasource.entity.ItemListResponse
import retrofit2.http.GET

interface IItemListService {

    @GET("api/items")
    suspend fun getItemList(): ItemListResponse
}