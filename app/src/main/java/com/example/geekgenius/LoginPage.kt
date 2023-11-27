package com.example.geekgenius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.geekgenius.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {

    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (password.length >= 6) {
                    firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, DashboardPage::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Mohon isi semua fields yang ada", Toast.LENGTH_SHORT).show()
            }
        }

        binding.linkRegister.setOnClickListener {
            startActivity(Intent(this, RegisterPage::class.java))
        }
        binding.btnBack.setOnClickListener{
            finish()
        }
    }

}