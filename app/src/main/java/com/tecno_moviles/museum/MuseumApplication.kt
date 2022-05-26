package com.tecno_moviles.museum

import android.app.Application
import com.tecno_moviles.museum.base.apiAuthModule
import com.tecno_moviles.museum.base.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class MuseumApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MuseumApplication)
            modules(apiAuthModule, appModule)
        }
    }
}