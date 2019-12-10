package com.farage.daniel.eng_zap_challenge_kotlin.base

import android.app.Application
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppBase: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppBase)
            androidLogger()
            modules(Modules.allModules)
        }
    }
}