package com.iua.museum.util

fun String.isTokenValid(): Boolean = (this.isNotEmpty() && this.isNotBlank())

fun String.clearQR(): String = (this.replace("\n", ""))