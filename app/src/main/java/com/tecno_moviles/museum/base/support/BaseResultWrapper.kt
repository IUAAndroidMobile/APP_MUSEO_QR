package com.tecno_moviles.museum.base.support

import com.tecno_moviles.museum.base.ErrorModel

sealed class BaseResultWrapper<out T> {
    data class ApiSuccess<out T>(val value: T): BaseResultWrapper<T>()
    data class ApiError(val error: ErrorModel): BaseResultWrapper<Nothing>()
}