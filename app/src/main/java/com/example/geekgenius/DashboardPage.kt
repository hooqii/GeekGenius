package com.example.geekgenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geekgenius.databinding.ActivityDashboardPageBinding
import com.geek.app.ui.article.ArticleFragment
import com.geek.app.ui.encyclopedia.EncyclopediaFragment
import com.geek.app.ui.main.MainActivity
import com.geek.app.ui.profile.ProfileFragment

class DashboardPage : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = ActivityDashboardPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivProfile.setOnClickListener{
            navigateToProfileFragment()
         }

        binding.flInformasiKampus.setOnClickListener {
            startActivity(Intent(this, InfoKampusPage::class.java))
        }

        binding.flArtikel.setOnClickListener {
            navigateToArticleFragment()
        }

        binding.flEnsiklopedia.setOnClickListener {
            navigateToEncyclopedia()
        }

        binding.flTest.setOnClickListener {
            startActivity(Intent(this, LandingTesPage::class.java))
        }
    }
    private fun navigateToProfileFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(android.R.id.content, ProfileFragment()) //  android.R.id.content sebagai container utama
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun navigateToArticleFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(android.R.id.content, ArticleFragment()) //  android.R.id.content sebagai container utama
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun navigateToEncyclopedia() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(android.R.id.content, EncyclopediaFragment()) //  android.R.id.content sebagai container utama
        transaction.addToBackStack(null)
        transaction.commit()
    }

}