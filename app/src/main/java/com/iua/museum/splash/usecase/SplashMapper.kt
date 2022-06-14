package com.iua.museum.splash.usecase

import com.iua.museum.splash.datasource.entity.SplashEntityResponse

fun SplashEntityResponse.toUserModel() : SplashUseCaseModel {
    return SplashUseCaseModel()
}