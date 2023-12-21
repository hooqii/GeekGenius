package com.example.geekgenius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.example.geekgenius.databinding.ActivityLandingTesPageBinding


class LandingTesPage : AppCompatActivity() {

    private lateinit var binding: ActivityLandingTesPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val binding = ActivityLandingTesPageBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, InputTesPage::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener{
            finish()
        }

    }
}