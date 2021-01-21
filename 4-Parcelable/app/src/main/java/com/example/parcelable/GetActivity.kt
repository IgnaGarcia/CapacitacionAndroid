package com.example.parcelable

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercitacion2.User

class GetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val user = intent.getParcelableExtra<User>(MainActivity.USER_KEY)
        println(user)
        val textView = findViewById<TextView>(R.id.text)
        textView.text = user.toString()
    }
}