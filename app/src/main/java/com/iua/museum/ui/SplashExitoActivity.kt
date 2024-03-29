package com.iua.museum.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.museum.home.view.HomeActivity
import com.iua.museum.R
import java.util.*
import kotlin.concurrent.schedule

class SplashExitoActivity : AppCompatActivity() {

    var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_exito)

        timer.schedule(3000) {
            startActivity(Intent(this@SplashExitoActivity, HomeActivity::class.java))
            finish()
        }
    }

    override fun onPause() {
        timer.cancel()
        super.onPause()
    }
}