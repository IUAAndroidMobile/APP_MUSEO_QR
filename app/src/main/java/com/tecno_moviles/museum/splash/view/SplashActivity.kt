package com.tecno_moviles.museum.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tecno_moviles.museum.HomeActivity
import com.tecno_moviles.museum.R
import com.tecno_moviles.museum.splash.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel.callGetAuthToken()

        timer.schedule(5000) {
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }
    }

    override fun onPause() {
        timer.cancel()
        super.onPause()
    }
}