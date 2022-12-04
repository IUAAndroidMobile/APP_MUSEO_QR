package com.iua.museum.item_detail.datasource.service

import com.iua.museum.item_detail.datasource.entity.ItemDetailResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface IItemDetailService {

    @GET("api/v1/items/{id}")
    //@GET("https://mocki.io/v1/653fd1d8-2584-4b18-8967-04d2f8bae4a8")
    suspend fun getItemById(@Header("Authorization") token: String, @Path("id") id: String): ItemDetailResponse
}