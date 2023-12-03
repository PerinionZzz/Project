package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userlogin: EditText = findViewById(R.id.userlogin)
        val userEmail: EditText = findViewById(R.id.useremail)
        val userPassword: EditText = findViewById(R.id.userpassword)
        val button: Button = findViewById(R.id.button_reg)

        button.setOnClickListener{
            val login = userlogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login == "" || email == "" || password == "")
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, password)

                val db = BdHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен!", Toast.LENGTH_LONG).show()

                userlogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
         }

        }
    }
}