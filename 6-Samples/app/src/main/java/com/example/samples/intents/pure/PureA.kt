package com.example.samples.intents.pure

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.samples.R

class PureA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_a)

        val btnToB = findViewById<Button>(R.id.btnToB)
        btnToB.setOnClickListener{
            val i = Intent(this@PureA, PureB::class.java)
            /*
                .apply{
                    .putExtra()
                    ...
                }
             */
            startActivity(i)
        }
    }
}