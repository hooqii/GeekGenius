package com.example.geekgenius

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DetailKampusPage : AppCompatActivity() {

    companion object {
        const val EXTRA_LOGO_ID = "extra_logo_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kampus_page)

        val imageView: ImageView = findViewById(R.id.ivLogoKampus)

        // Mendapatkan ID gambar dari intent
        val logoId = intent.getIntExtra(EXTRA_LOGO_ID, 0)

        // Set gambar sesuai ID yang diterima
        if (logoId != 0) {
            imageView.setImageResource(logoId)
        }

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}
