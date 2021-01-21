package com.example.ejercitacion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SingUpActivity: AppCompatActivity() {
    companion object{
        const val USER_KEY = "usuario"
        const val USERNAME_KEY = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singup)

        setSupportActionBar(findViewById(R.id.toolbarSingUp))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val inputName = findViewById<EditText>(R.id.inputName)
        val inputSurname = findViewById<EditText>(R.id.inputSurname)
        val inputMail = findViewById<EditText>(R.id.inputMail)
        val inputUser = findViewById<EditText>(R.id.inputUsername)
        val inputPass = findViewById<EditText>(R.id.inputPassword)
        val inputPass2 = findViewById<EditText>(R.id.inputConfirmPassword)
        val aceptTerms = findViewById<CheckBox>(R.id.inputCheckBox)
        val btnSingUp = findViewById<Button>(R.id.btnSendSingUp)

        btnSingUp.setOnClickListener{ validate(aceptTerms, inputName, inputSurname, inputMail, inputUser, inputPass, inputPass2) }
    }

    private fun checkName(name : String?) : Boolean = if(name == null) false else (name.length >= 3 && """[a-zA-Z\s]*""".toRegex().matches(name))

    private fun checkSurname(surname : String?) : Boolean = if(surname == null) false else (surname.length >= 3 && """[a-zA-Z\s]*""".toRegex().matches(surname))

    private fun checkMail(mail : String?) : Boolean = if(mail == null) false else android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()

    private fun checkUsername(username : String?) : Boolean = if(username == null) false else username.length >= 5

    private fun checkPassword(password: String?) : Boolean =  if(password == null) false else password.length >= 5

    private fun checkPassword2(password : String?, confPassword : String?) : Boolean = password!! == confPassword!!

    private fun validate(aceptTerms : CheckBox,
                         inputName : EditText, inputSurname : EditText,
                         inputMail : EditText, inputUser : EditText,
                         inputPass : EditText, inputPass2 : EditText){

        val name : String? = inputName.text.toString()
        var isValidName : Boolean= checkName(name)
        if(!isValidName) inputName.setError("El nombre es requerido")

        val surname : String? = inputSurname.text.toString()
        var isValidSurname : Boolean = checkSurname(surname)
        if(!isValidSurname) inputSurname.setError("El apellido es requerido")

        val mail : String? = inputMail.text.toString()
        var isValidMail : Boolean= checkMail(mail)
        if(!isValidMail) inputMail.setError("El correo electronico es requerido")

        val username : String? = inputUser.text.toString()
        var isValidUsername : Boolean= checkUsername(username)
        if(!isValidUsername) inputUser.setError("El nombre de usuario es requerido")

        val password : String? = inputPass.text.toString()
        var isValidPassword : Boolean = checkPassword(password)
        if(!isValidPassword) inputPass.setError("La contraseña es requerida", null)

        val confPassword : String? = inputPass2.text.toString()
        var isValidPassword2 : Boolean = checkPassword(confPassword)
        if(!isValidPassword2) inputPass2.setError("La confirmacion es requerida", null) else{
            isValidPassword2 = checkPassword2(password, confPassword)
            if(!isValidPassword2) inputPass2.setError("La contraseña no es la misma", null)
        }

        if(!aceptTerms.isChecked) aceptTerms.setError("") else aceptTerms.setError(null)
        if(aceptTerms.isChecked && isValidPassword2 && isValidPassword && isValidUsername && isValidMail && isValidSurname && isValidName) {
            val user = User(name = name!!, surname = surname!!, mail = mail!!, username = username!!, password = password!!)
            val i = Intent(this@SingUpActivity, HomeActivity::class.java)
            var bundle = Bundle()
            bundle.putParcelable(USERNAME_KEY, user)
            i.putExtra(USER_KEY, bundle)
            startActivity(i)
        }
    }
}