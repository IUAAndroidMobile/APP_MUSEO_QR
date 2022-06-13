package com.iua.museum.base.support

sealed class BaseResultWrapper<out T> {
    data class ApiSuccess<out T>(val value: T): BaseResultWrapper<T>()
    data class ApiError(val error: ErrorModel): BaseResultWrapper<Nothing>()
}