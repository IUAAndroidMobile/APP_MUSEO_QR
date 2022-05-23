package com.tecno_moviles.museum.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tecno_moviles.museum.HomeActivity
import com.tecno_moviles.museum.R
import java.util.*

import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {

    var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

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