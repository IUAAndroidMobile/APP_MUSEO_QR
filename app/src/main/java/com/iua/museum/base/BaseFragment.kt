package com.iua.museum.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iua.museum.R
import com.iua.museum.base.viewModel.BaseViewModel
import com.iua.museum.base.viewModel.observe
import com.iua.museum.splash.view.SplashActivity

abstract class BaseFragment : Fragment(), BaseViewActionsInterface {

    //Generic Views
    private lateinit var progressView: View

    abstract fun getViewModel(): BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as? ViewGroup)?.let { viewGroup ->
            initProgressView(viewGroup)
        }
        bindsObserversToLiveData()
    }

    private fun bindsObserversToLiveData() {
        observe(getViewModel().bindingDelegate.showProgressView, this::showProgressView)
        observe(getViewModel().bindingDelegate.hideProgressView, this::hideProgressView)
    }

    override fun showProgressView(u: Unit) {
        progressView.toVisible()
    }

    override fun hideProgressView(u: Unit) {
        progressView.toGone()
    }

    private fun initProgressView(viewGroupRoot: ViewGroup) {
        progressView = View.inflate(context, R.layout.custom_loading, viewGroupRoot)
            .findViewById(R.id.v_progress)
        progressView.toGone()
    }

    override fun navigateToSplashScreenAndRenewToken(u: Unit) {
        val intent = Intent(context, SplashActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    }

}