package com.iua.museum.preferences

interface IAppPreferencesRepository {
    fun setTokenU(tokenU: String)
    fun getTokenU() : String?

    fun setIsNewUser(isNewUser: Boolean)
    fun getIsNewUser(): Boolean
}