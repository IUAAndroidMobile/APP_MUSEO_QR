package com.iua.museum.list.datasource.entity

import com.google.gson.annotations.SerializedName

data class ItemListRequest (
    @SerializedName("example_field")  val exampleField : String = ""
)