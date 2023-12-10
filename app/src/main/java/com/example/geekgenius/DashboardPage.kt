package com.example.geekgenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geekgenius.databinding.ActivityDashboardPageBinding
import com.geek.app.ui.article.ArticleFragment
import com.geek.app.ui.main.MainActivity

class DashboardPage : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = ActivityDashboardPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.flInformasiKampus.setOnClickListener {
            startActivity(Intent(this, InfoKampusPage::class.java))
        }

        binding.flArtikel.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.flEnsiklopedia.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.flTest.setOnClickListener {
            startActivity(Intent(this, LandingTesPage::class.java))
        }
    }
}