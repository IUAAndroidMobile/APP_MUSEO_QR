package com.iua.museum.terms_conditions.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.iua.museum.base.BaseBindingDelegate

class TermsAndConditionsBindingDelegate: BaseBindingDelegate() {
    //Region sign Terms and conditions
    private val _setTermsAndConditionsSignedLiveData = MutableLiveData<Boolean>()
    val setTermsAndConditionsSigned: LiveData<Boolean> get() = _setTermsAndConditionsSignedLiveData
    fun setTermsAndConditionsSignedPostValue(termsAndConditionsSign: Boolean) {
        _setTermsAndConditionsSignedLiveData.value = termsAndConditionsSign
    }
    //End region sign terms and conditions
}