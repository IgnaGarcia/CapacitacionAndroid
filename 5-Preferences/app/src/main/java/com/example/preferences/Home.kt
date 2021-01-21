package com.example.preferences

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.sample.sample2.local.SharedPreferencesManager

class Home : AppCompatActivity() {
    private val sharedPrefManager : SharedPreferencesManager = SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val userName = sharedPrefManager.getUser(this@Home)

        val tvHome = findViewById<TextView>(R.id.tvHome)
        tvHome.text = "hola $userName"

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener{
            val i = Intent(this@Home, Login::class.java)
            SharedPreferencesManager.clearData(this@Home)
            startActivity(i)
        }
    }


}