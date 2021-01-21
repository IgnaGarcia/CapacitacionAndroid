package com.example.parcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ejercitacion2.User

class MainActivity : AppCompatActivity() {
    companion object{
        const val USER_KEY = "usuario"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnSend)
        btn.setOnClickListener{
            val user = User(name = "name", surname = "surname", mail = "mail", username = "username", password = "password")
            val i = Intent(this@MainActivity, GetActivity::class.java)
            intent.putExtra(USER_KEY, user)
            println(user)
            println(intent.getParcelableExtra<User>(USER_KEY))
            startActivity(i)
        }
    }
}