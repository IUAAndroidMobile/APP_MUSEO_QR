package com.tecno_moviles.museum

import android.app.Application
import com.tecno_moviles.museum.base.apiAuthModule
import com.tecno_moviles.museum.base.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

open class MuseumApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Start Koin
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MuseumApplication)
            modules(apiAuthModule, appModule)
        }
    }
}