package com.tecno_moviles.museum.preferences

import android.content.SharedPreferences
import com.tecno_moviles.museum.util.USER_PREFERENCE_SHOW_TUTORIAL
import com.tecno_moviles.museum.util.USER_PREFERENCE_TOKEN

class AppPreferencesRepository(
    private val sharedPreferences: SharedPreferences
):  IAppPreferencesRepository{

    override fun setTokenU(tokenU: String) {
        sharedPreferences.edit().putString(USER_PREFERENCE_TOKEN, tokenU)
    }

    override fun getTokenU(): String? = sharedPreferences.getString(USER_PREFERENCE_TOKEN, "")

    override fun setShowTutorial(tutorial: Boolean) {
        sharedPreferences.edit().putBoolean(USER_PREFERENCE_SHOW_TUTORIAL, tutorial)
    }

    override fun getTutorial(): Boolean = sharedPreferences.getBoolean(USER_PREFERENCE_SHOW_TUTORIAL, false)
}