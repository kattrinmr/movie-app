package com.katerina.morozova

import android.app.Application
import com.katerina.morozova.di.AppComponent
import com.katerina.morozova.di.DaggerAppComponent

class MoviesApp : Application() {
    val appComponent: AppComponent = DaggerAppComponent.builder().application(this).build()
}