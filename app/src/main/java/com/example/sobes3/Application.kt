package com.example.sobes3

import android.app.Application
import com.example.myapplication.di.photosFragmentModuule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    photosFragmentModuule
                )
            )
        }
    }
}
