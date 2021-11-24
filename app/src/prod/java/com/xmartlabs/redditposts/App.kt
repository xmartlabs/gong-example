package com.xmartlabs.redditposts

import com.xmartlabs.redditposts.device.di.DiAppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : AppBase() {
    companion object {
        lateinit var instance: App
            private set
    }

    override fun setupKoinModules() {
        startKoin {
            androidContext(this@App)
            modules(DiAppModules.provideModules())
        }
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}
