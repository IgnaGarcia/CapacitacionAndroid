package com.example.ejercitacion2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)

        val btnSingUp = findViewById<Button>(R.id.btnSingUp)
        btnSingUp.setOnClickListener{
            val i = Intent(this@StartActivity, SingUpActivity::class.java)
            startActivity(i)
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener{
            val i = Intent(this@StartActivity, LoginActivity::class.java)
            startActivity(i)
        }

    }
}