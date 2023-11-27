package com.example.geekgenius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import com.example.geekgenius.databinding.ActivityWellcomePageBinding
import com.google.firebase.auth.FirebaseAuth


class WellcomePage : AppCompatActivity() {

    private lateinit var binding : ActivityWellcomePageBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityWellcomePageBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLoginEmail.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))
        }

        binding.linkRegister.setOnClickListener {
            startActivity(Intent(this, RegisterPage::class.java))
        }
    }
}