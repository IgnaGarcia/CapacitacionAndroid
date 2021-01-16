package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnActB)
        btn.setOnClickListener{
            //val i = Intent(this@ActivityA, ActivityB::class.java) // Explicito
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/"))
            startActivity(i)
        }
    }

    override fun onStart(){
        super.onStart()
        Toast.makeText( this, "ON START", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText( this, "ON RESUME", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText( this, "ON PAUSE", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText( this, "ON STOP", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText( this, "ON DESTROY", Toast.LENGTH_SHORT).show()
    }
}