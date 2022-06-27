package com.iua.museum.item_detail.datasource.service

import com.iua.museum.item_detail.datasource.entity.ItemDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface IItemDetailService {

    //@GET("api/items/{id}")
    //    suspend fun getItemById(@Path("id") id: Int): ItemDetailResponse
    @GET("https://mocki.io/v1/653fd1d8-2584-4b18-8967-04d2f8bae4a8")
    suspend fun getItemById(): ItemDetailResponse
}