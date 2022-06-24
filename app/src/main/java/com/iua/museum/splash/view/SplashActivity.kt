package com.iua.museum.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.iua.museum.home.view.HomeActivity
import com.iua.museum.R
import com.iua.museum.splash.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Init observers
        splashViewModel.splashBindingDelegate.setIsNewUser.observe(this, ::onIsNewUserEvent)
        splashViewModel.splashBindingDelegate.setTermsAndCondition.observe(this, ::showTermsAndConditions)

        splashViewModel.callGetAuthToken()

        timer.schedule(2000) {
            splashViewModel.shouldShowTermsAndConditions()
        }
    }

    private fun showTermsAndConditions(showTermsAndCondition: Boolean?) {
        showTermsAndCondition?.let {
            if (!it) {
                Navigation.findNavController(this, R.id.nav_host_fragment_splash).navigate(SplashFragmentDirections.actionSplashFragmentToTermsAndConditionsFragment())
            } else {
                splashViewModel.isNewUser()
            }
        }
    }

    private fun onIsNewUserEvent(isNewUser: Boolean?) {
        isNewUser?.let {
            if (it) {
                Navigation.findNavController(this, R.id.nav_host_fragment_splash).navigate(SplashFragmentDirections.actionSplashFragmentToHelpFragment())
                splashViewModel.saveIsNewUser()
            } else {
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
                finish()
            }
        }
    }

    override fun onPause() {
        timer.cancel()
        super.onPause()
    }
}