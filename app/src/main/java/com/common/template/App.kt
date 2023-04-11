package com.common.template

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlin.properties.Delegates

@HiltAndroidApp
class App:Application() {
    companion object {
        var application by Delegates.notNull<Application>()
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}