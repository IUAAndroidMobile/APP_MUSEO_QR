package com.tecno_moviles.museum.splash.usecase

import com.tecno_moviles.museum.splash.datasource.entity.SplashEntityResponse

fun SplashEntityResponse.toUserModel() : SplashUseCaseModel {
    return SplashUseCaseModel()
}