package com.iua.museum.list.usecase

data class Favorito (
    val imagenNombre : String? = null,
    val titulo : String? = null,
    val descrip : String? = null,
    var esFav: Boolean
)