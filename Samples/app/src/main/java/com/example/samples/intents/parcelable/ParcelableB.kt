package com.example.samples.intents.parcelable

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.samples.R

class ParcelableB : AppCompatActivity() {
    companion object{
        const val INPUT_KEY = "input"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_b)

        val tvReciever = findViewById<TextView>(R.id.tvReciever)
        val extra : Objecto? = intent.extras?.getParcelable(INPUT_KEY)
        tvReciever.text = extra?.name
    }
}