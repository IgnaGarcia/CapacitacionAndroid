package com.example.preferences

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.sample.sample2.local.SharedPreferencesManager

class Login : AppCompatActivity() {
    private val sharedPrefManager : SharedPreferencesManager = SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val username : String? = sharedPrefManager.getUser(this@Login)

        if(!username.isNullOrEmpty()) goToHome()
        else {
            setContentView(R.layout.login)
            val btnIngresar = findViewById<Button>(R.id.btnIngresar)
            var etUsername  = findViewById<EditText>(R.id.etUsername)

            btnIngresar.setOnClickListener {
                sharedPrefManager.saveUser(this@Login, etUsername.text.toString())
                goToHome()
            }
        }
    }

    private fun goToHome(){
        val i = Intent(this@Login, Home::class.java)
        startActivity(i)
    }
}