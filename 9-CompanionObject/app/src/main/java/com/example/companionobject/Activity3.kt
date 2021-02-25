package com.example.companionobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Activity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)
        MainActivity.val1 = -10
        MainActivity.val2 = "actividad 3"
        MainActivity.val3 = false

        val tvMain = findViewById<TextView>(R.id.tvMain)
        tvMain.text = "${MainActivity.val1}  ${MainActivity.val2}  ${MainActivity.val3}"

        val btnGoTo2 = findViewById<Button>(R.id.btnGoTo2)
        btnGoTo2.setOnClickListener { startActivity(Intent(this@Activity3, Activity2::class.java)) }
        val btnGoToH = findViewById<Button>(R.id.btnGoToH)
        btnGoToH.setOnClickListener { startActivity(Intent(this@Activity3, MainActivity::class.java)) }
    }
}