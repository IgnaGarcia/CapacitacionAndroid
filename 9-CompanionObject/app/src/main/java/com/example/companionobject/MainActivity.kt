package com.example.companionobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object{
        var val1 : Int = 0
        var val2 : String = "Undef"
        var val3 : Boolean = true

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMain = findViewById<TextView>(R.id.tvMain)
        tvMain.text = "$val1  $val2  $val3"

        val btnGoTo2 = findViewById<Button>(R.id.btnGoTo2)
        btnGoTo2.setOnClickListener { startActivity(Intent(this@MainActivity, Activity2::class.java)) }
        val btnGoTo3 = findViewById<Button>(R.id.btnGoTo3)
        btnGoTo3.setOnClickListener { startActivity(Intent(this@MainActivity, Activity3::class.java)) }
    }
}