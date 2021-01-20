package com.example.samples.intents.extra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.samples.R

class ExtraA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_a)

        val btnToB = findViewById<Button>(R.id.btnToB)
        val etInput = findViewById<EditText>(R.id.etInput)

        btnToB.setOnClickListener{
            val i = Intent(this@ExtraA, ExtraB::class.java)
            i.putExtra(ExtraB.INPUT_KEY, etInput.text.toString())
            startActivity(i)
        }
    }
}