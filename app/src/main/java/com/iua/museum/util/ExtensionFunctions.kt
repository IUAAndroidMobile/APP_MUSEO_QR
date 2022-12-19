package com.iua.museum.util

fun String.isTokenValid(): Boolean = (this.isNotEmpty() && this.isNotBlank() && this != ERROR_STATUS_TIMEOUT)

fun String.clearQR(): String = (this.replace("\n", ""))