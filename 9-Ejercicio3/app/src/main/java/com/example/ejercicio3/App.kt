package com.example.ejercicio3

import android.app.Application

//Clase para acceder a los Resources sin context
class App : Application() {
    companion object {
        lateinit var instance: App private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}