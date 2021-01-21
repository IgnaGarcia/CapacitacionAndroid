package com.example.samples.intents.extra

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.samples.R

class ExtraB : AppCompatActivity() {
    companion object{
        const val INPUT_KEY = "input"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_b)

        val tvReciever = findViewById<TextView>(R.id.tvReciever)
        val extra = intent.extras?.getString(INPUT_KEY)
        tvReciever.text = extra
    }
}