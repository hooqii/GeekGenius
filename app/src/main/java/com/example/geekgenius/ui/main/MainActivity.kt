package com.geek.app.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.geekgenius.R
import com.example.geekgenius.databinding.ActivityMainBinding
import com.geek.app.ui.article.ArticleFragment
//import com.geek.app.ui.ensiklopedia.EnsiklopediaFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FRAGMENT = "extra_fragment"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_main) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNav.setupWithNavController(navController)

        handleIntentFragment()
    }

    private fun handleIntentFragment() {
        val fragment = intent.getSerializableExtra(EXTRA_FRAGMENT) as Fragment?
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_main, fragment)
                .commit()
        }
    }
}
