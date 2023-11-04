package ru.yesds.yesdsapp

import android.app.Application
import ru.yesds.yesdsapp.di.AppComponent
import ru.yesds.yesdsapp.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        // create component
        dagger = DaggerAppComponent.factory().create(this)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}