// InfoKampusPage.kt

package com.example.geekgenius

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geekgenius.ui.adapter.LogoAdapter

class InfoKampusPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_kampus_page)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val logoList = listOf(
            R.drawable.logo_ui, R.drawable.logo_ui, R.drawable.logo_ui, R.drawable.logo_ui, R.drawable.logo_ui, R.drawable.logo_ui, R.drawable.logo_ui, R.drawable.logo_ui, R.drawable.logo_ui,
        )
        val logoAdapter = LogoAdapter(logoList) { clickedLogo ->
            // Handle logo click, navigate to DetailKampusActivity
            val intent = Intent(this, DetailKampusPage::class.java)
            intent.putExtra(DetailKampusPage.EXTRA_LOGO_ID, clickedLogo)
            startActivity(intent)
        }

        recyclerView.layoutManager = GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = logoAdapter

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}

