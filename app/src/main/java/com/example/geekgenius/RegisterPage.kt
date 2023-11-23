package com.example.geekgenius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.widget.TextView


class RegisterPage : AppCompatActivity() {

    private lateinit var textLinkLogin : TextView
    private lateinit var buttonBack : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        val editTextEmail = findViewById<EditText>(R.id.etEmail)
        val editTextPassword = findViewById<EditText>(R.id.editText)
        val editTextPassword2 = findViewById<EditText>(R.id.editText2)
        val buttonRegister = findViewById<Button>(R.id.btnRegister)
        textLinkLogin = findViewById(R.id.linkLogin)
        buttonBack = findViewById(R.id.btnBack)

        buttonRegister.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val password2 = editTextPassword2.text.toString().trim()

            if (isValidInput(email, password, password2)) {
                //data belum ada yang nampung
                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginPage::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Isi semua kolom dengan benar", Toast.LENGTH_SHORT).show()
            }
        }
        textLinkLogin.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
        buttonBack.setOnClickListener{
            finish()
        }
    }

    private fun isValidInput(email: String, password: String, password2: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty() && password == password2
    }
}