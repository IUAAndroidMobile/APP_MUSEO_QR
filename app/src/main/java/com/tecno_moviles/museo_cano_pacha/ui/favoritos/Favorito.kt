package com.tecno_moviles.museo_cano_pacha.ui.favoritos

data class Favorito (
    val imagenNombre : String? = null,
    val titulo : String? = null,
    val descrip : String? = null,
    var esFav: Boolean
)