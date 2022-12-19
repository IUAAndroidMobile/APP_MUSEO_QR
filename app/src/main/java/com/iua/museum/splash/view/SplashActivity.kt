package com.iua.museum.splash.view

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.iua.museum.home.view.HomeActivity
import com.iua.museum.R
import com.iua.museum.databinding.ActivitySplashBinding
import com.iua.museum.splash.viewModel.SplashViewModel
import com.iua.museum.util.isTokenValid
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    private var binding: ActivitySplashBinding? = null

    var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Init observers
        splashViewModel.splashBindingDelegate.setUserToken.observe(this, ::onUserToken)
        splashViewModel.splashBindingDelegate.setIsNewUser.observe(this, ::onIsNewUserEvent)
        splashViewModel.splashBindingDelegate.setTermsAndCondition.observe(
            this,
            ::showTermsAndConditions
        )

        timer.schedule(4000) {
            //splashViewModel.shouldShowTermsAndConditions()
        }
    }

    override fun onResume() {
        super.onResume()
        startAccess()
    }

    private fun startAccess() {
        splashViewModel.callGetAuthToken()
        //binding.
        val splashFragment = supportFragmentManager.fragments.first()
        if (splashFragment is SplashFragment) {
            splashFragment.showSplashLoading()
        }

    }

    private fun onUserToken(token: String) {
        if (token.isNotEmpty() && token.isTokenValid()) {
            splashViewModel.shouldShowTermsAndConditions()
        } else {
            val splashFragment = supportFragmentManager.fragments.first()
            if (splashFragment is SplashFragment) {
                splashFragment.hideSplashloading()
            }
            val dialog = AlertDialog.Builder(this).setMessage(R.string.splash_dialog_message)
                .setPositiveButton(
                    R.string.spalsh_positive_button
                ) { _, _ -> startAccess() }
                .setNegativeButton(
                    R.string.splash_negative_button
                ) { _, _ ->
                    finishAffinity()
                }
            dialog.create().show()
        }
    }

    private fun showTermsAndConditions(showTermsAndCondition: Boolean?) {
        showTermsAndCondition?.let {
            if (!it) {
                Navigation.findNavController(this, R.id.nav_host_fragment_splash)
                    .navigate(SplashFragmentDirections.actionSplashFragmentToTermsAndConditionsFragment())
            } else {
                splashViewModel.isNewUser()
            }
        }
    }

    private fun onIsNewUserEvent(isNewUser: Boolean?) {
        isNewUser?.let {
            if (it) {
                Navigation.findNavController(this, R.id.nav_host_fragment_splash)
                    .navigate(SplashFragmentDirections.actionSplashFragmentToHelpFragment())
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