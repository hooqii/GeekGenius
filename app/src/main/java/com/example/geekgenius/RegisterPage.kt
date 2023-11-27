package com.example.geekgenius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.widget.TextView
import com.example.geekgenius.databinding.ActivityRegisterPageBinding
import com.example.geekgenius.databinding.ActivityWellcomePageBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterPage : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterPageBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password.length >= 6 && confirmPassword.length >= 6) {
                    if (password == confirmPassword) {
                        firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(this, "Register berhasil", Toast.LENGTH_SHORT)
                                        .show()
                                    val intent = Intent(this, LoginPage::class.java)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(this, "Register gagal", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                    } else {
                        Toast.makeText(
                            this,
                            "Password & confirm password berbeda",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Mohon isi semua fields yang ada", Toast.LENGTH_SHORT).show()
            }
        }
        binding.linkLogin.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}