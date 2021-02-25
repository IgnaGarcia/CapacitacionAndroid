package com.example.companionobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        MainActivity.val1 = 10
        MainActivity.val2 = "actividad 2"
        MainActivity.val3 = false

        val tvMain = findViewById<TextView>(R.id.tvMain)
        tvMain.text = "${MainActivity.val1}  ${MainActivity.val2}  ${MainActivity.val3}"

        val btnGoToH = findViewById<Button>(R.id.btnGoToH)
        btnGoToH.setOnClickListener { startActivity(Intent(this@Activity2, MainActivity::class.java)) }
        val btnGoTo3 = findViewById<Button>(R.id.btnGoTo3)
        btnGoTo3.setOnClickListener { startActivity(Intent(this@Activity2, Activity3::class.java)) }
    }
}