package com.example.ejercitacion2

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val user : User? = intent.getBundleExtra(SingUpActivity.USER_KEY)?.getParcelable(SingUpActivity.USERNAME_KEY)
        val username : String? = intent.extras?.getString(LoginActivity.USER_KEY)

        val value = user?.username ?: (username ?: "null")
        val textView = findViewById<TextView>(R.id.textContent)
        textView.text = "Bienvenid@,\n$value"
    }
}