package com.tecno_moviles.museum.preferences

interface IAppPreferencesRepository {
    fun setTokenU(tokenU: String)
    fun getTokenU() : String?

    fun setShowTutorial(tutorial: Boolean)
    fun getTutorial(): Boolean
}