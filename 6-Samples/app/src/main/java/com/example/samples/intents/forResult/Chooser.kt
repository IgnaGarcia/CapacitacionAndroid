package com.example.samples.intents.forResult

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.samples.R
import java.lang.Exception

class Chooser : AppCompatActivity() {
    companion object{
        const val REQUEST_KEY = 130
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_a)

        val btnToB = findViewById<Button>(R.id.btnToB)

        btnToB.setOnClickListener{
            val i = Intent(Intent.ACTION_PICK).setType("image/*")
            startActivityForResult(i, REQUEST_KEY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_KEY){
            if(resultCode == Activity.RESULT_OK){
                data?.let {
                    val tvRespuesta = findViewById<TextView>(R.id.tvRespuesta)
                    try {
                        val imageUri = data.data
                        val imageStream = contentResolver.openInputStream(imageUri!!)
                        val selectedImage = BitmapFactory.decodeStream(imageStream)
                        val imgvReciver = findViewById<ImageView>(R.id.imgvReciver)
                        imgvReciver.setImageBitmap(selectedImage)
                    } catch (err : Exception) {
                        tvRespuesta.text = err.message
                    }
                }
            }
        }
    }
}