package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Actividad2 : AppCompatActivity() {
    companion object{
        const val REPLY_KEY = "reply"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad2layout)

        val btnSend = findViewById<Button>(R.id.btnEnviar)
        val etQuestion = findViewById<EditText>(R.id.inputRespuesta)

        btnSend.setOnClickListener{
            val i = Intent(this@Actividad2, Actividad1::class.java)
            i.putExtra(REPLY_KEY, etQuestion.text.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }
}