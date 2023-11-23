package com.example.geekgenius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginPage : AppCompatActivity() {

    private val registeredEmail = "contoh@gmail.com"
    private val registeredPassword = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val editTextEmail = findViewById<EditText>(R.id.etEmail)
        val editTextPassword = findViewById<EditText>(R.id.etPasswordL)
        val buttonLogin = findViewById<Button>(R.id.btnLogin)

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (isValidCredentials(email, password)) {

                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, DashboardPage::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isValidCredentials(email: String, password: String): Boolean {
        return email == registeredEmail && password == registeredPassword
    }
}