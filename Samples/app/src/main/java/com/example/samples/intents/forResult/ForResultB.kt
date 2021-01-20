package com.example.samples.intents.forResult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.samples.R

class ForResultB : AppCompatActivity() {
    companion object {
        const val REPLY_KEY = "reply"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_b)

        val etResult = findViewById<EditText>(R.id.etResult)
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val i = Intent(this@ForResultB, ForResultA::class.java)
            i.putExtra(REPLY_KEY, etResult.text.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }
}