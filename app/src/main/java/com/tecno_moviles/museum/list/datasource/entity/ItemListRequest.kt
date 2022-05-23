package com.tecno_moviles.museum.list.datasource.entity

import com.google.gson.annotations.SerializedName

data class ItemListRequest (
    @SerializedName("example_field")  val exampleField : String = ""
)