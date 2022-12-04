package com.iua.museum.splash.usecase

import com.iua.museum.splash.datasource.entity.AppLoginEntityResponse

fun AppLoginEntityResponse.toUserModel() : AppLoginUseCaseModel {
    return AppLoginUseCaseModel(this.token)
}