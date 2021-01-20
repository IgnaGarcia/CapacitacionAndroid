package com.example.samples.intents.forResult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.samples.R

class ForResultA : AppCompatActivity() {
    companion object{
        const val REQUEST_KEY = 130
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_a)

        val btnToB = findViewById<Button>(R.id.btnToB)

        btnToB.setOnClickListener{
            val i = Intent(this@ForResultA, ForResultB::class.java)
            startActivityForResult(i, REQUEST_KEY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_KEY){
            if(resultCode == Activity.RESULT_OK){
                data?.let {
                    val tvRespuesta = findViewById<TextView>(R.id.tvRespuesta)
                    if(it.hasExtra(ForResultB.REPLY_KEY)){
                        tvRespuesta.text = "La respuesta es... ${it.getStringExtra(ForResultB.REPLY_KEY)}"
                    }else{
                        tvRespuesta.text = "No se recibió ninguna respuesta"
                    }
                }
            }
        }
    }
}