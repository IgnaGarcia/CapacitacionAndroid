package com.example.samples.intents.parcelable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.samples.R

class ParcelableA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_a)

        val btnToB = findViewById<Button>(R.id.btnToB)
        val etInput = findViewById<EditText>(R.id.etInput)
        val etPass = findViewById<EditText>(R.id.etPass)

        btnToB.setOnClickListener{
            val i = Intent(this@ParcelableA, ParcelableB::class.java)
            val objeto = Objecto(name = etInput.text.toString(),
                                pass = etPass.text.toString())
            i.putExtra(ParcelableB.INPUT_KEY, objeto)
            startActivity(i)
        }
    }
}