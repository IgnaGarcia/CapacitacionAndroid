package com.example.ejercitacion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {
    companion object{
        const val USER_KEY = "usuario"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        setSupportActionBar(findViewById(R.id.toolbarLogin))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val inputUser = findViewById<EditText>(R.id.inputUsernameLogin)
        val inputPass = findViewById<EditText>(R.id.inputPasswordLogin)
        val btnLogin = findViewById<Button>(R.id.btnSendLogin)

        btnLogin.setOnClickListener{ validate(inputUser, inputPass) }
    }

    private fun checkUsername(username : String?) : Boolean = if(username == null) false else username.length >= 5

    private fun checkPassword(password: String?) : Boolean =  if(password == null) false else password.length >= 5

    private fun validate(inputUser : EditText, inputPass : EditText){
        val username : String? = inputUser.text.toString()
        var isValidUsername : Boolean= checkUsername(username)
        if(!isValidUsername) inputUser.setError("El nombre de usuario es requerido")

        val password : String? = inputPass.text.toString()
        var isValidPassword : Boolean = checkPassword(password)
        if(!isValidPassword) inputPass.setError("La contraseña es requerida", null)

        if(isValidPassword && isValidUsername) {
            val i = Intent(this@LoginActivity, HomeActivity::class.java)
            i.putExtra(USER_KEY, username)
            startActivity(i)
        }
    }
}