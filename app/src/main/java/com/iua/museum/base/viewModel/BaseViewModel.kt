package com.iua.museum.base.viewModel

import androidx.lifecycle.ViewModel
import com.iua.museum.preferences.IAppPreferencesRepository
import org.koin.core.context.GlobalContext

open class BaseViewModel(
    open val bindingDelegate: BaseBindingDelegate,
    private val presentationDelegate: BasePresenterDelegate
) : ViewModel() {

    protected val appPreferencesRepository: IAppPreferencesRepository by lazy { GlobalContext.get().get<IAppPreferencesRepository>() }

    fun callLogout() {
        //TODO: Expire authorization here if necessary.
    }

    fun saveIsNewUser() {
        appPreferencesRepository.setIsNewUser(false)
    }

}