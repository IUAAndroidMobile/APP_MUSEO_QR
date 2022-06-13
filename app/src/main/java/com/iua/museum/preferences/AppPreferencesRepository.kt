package com.iua.museum.preferences

import android.content.SharedPreferences
import com.iua.museum.util.USER_PREFERENCE_IS_NEW_USER
import com.iua.museum.util.USER_PREFERENCE_TOKEN

class AppPreferencesRepository(
    private val sharedPreferences: SharedPreferences
):  IAppPreferencesRepository{

    override fun setTokenU(tokenU: String) {
        sharedPreferences.edit().putString(USER_PREFERENCE_TOKEN, tokenU).apply()
    }

    override fun getTokenU(): String? = sharedPreferences.getString(USER_PREFERENCE_TOKEN, "")

    override fun setIsNewUser(isNewUser: Boolean) {
        sharedPreferences.edit().putBoolean(USER_PREFERENCE_IS_NEW_USER, isNewUser).apply()
    }

    override fun getIsNewUser(): Boolean = sharedPreferences.getBoolean(USER_PREFERENCE_IS_NEW_USER, true)
}