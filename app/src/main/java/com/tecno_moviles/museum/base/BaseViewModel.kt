package com.tecno_moviles.museum.base

import androidx.lifecycle.ViewModel
import com.tecno_moviles.museum.preferences.AppPreferencesRepository
import org.koin.core.context.GlobalContext

open class BaseViewModel(
    open val bindingDelegate: BaseBindingDelegate,
    private val presentationDelegate: BasePresenterDelegate
) : ViewModel() {

    private val appPreferencesRepository: AppPreferencesRepository by lazy { GlobalContext.get().get<AppPreferencesRepository>() }

    fun callLogout() {
        //TODO: Expire authorization here if necessary.
    }

}