package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Actividad1 : AppCompatActivity() {
    companion object{
        const val ANSWER_REQUEST_KEY = 145
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad1layout)

        val btnIrAQ = findViewById<Button>(R.id.btnNext)
        btnIrAQ.setOnClickListener{
            val i = Intent(this@Actividad1,  Actividad2::class.java)
            startActivityForResult(i, ANSWER_REQUEST_KEY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == ANSWER_REQUEST_KEY){
            if(resultCode == Activity.RESULT_OK){
                data?.let{
                    val tvRespuesta = findViewById<TextView>(R.id.outputRespuesta)
                    if(it.hasExtra(Actividad2.REPLY_KEY)) tvRespuesta.text = "La respuesta es... ${it.getStringExtra(Actividad2.REPLY_KEY)}"
                    else tvRespuesta.text = "La respuesta no se recibio"
                }
            }
        }
    }
}