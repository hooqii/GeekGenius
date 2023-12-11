package com.example.geekgenius

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geekgenius.ui.adapter.KampusAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InfoKampusPage : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_kampus_page)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference.child("kampuses")

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val logoList = listOf(
            R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5, R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8, R.drawable.logo_9,
        )
        val logoAdapter = KampusAdapter(logoList) { clickedLogo ->
            // Handle logo click, navigate to DetailKampusActivity
            val intent = Intent(this, DetailKampusPage::class.java)
            intent.putExtra(DetailKampusPage.EXTRA_LOGO_ID, clickedLogo)
            startActivity(intent)
        }

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = logoAdapter

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}
