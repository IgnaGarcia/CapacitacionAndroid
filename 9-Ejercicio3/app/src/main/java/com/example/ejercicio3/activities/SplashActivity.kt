package com.example.ejercicio3.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio3.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //TODO: splash que verifique si hay sharedpreferences, si las hay se logea automaticamente, sino pasa al login/singin
    }
}