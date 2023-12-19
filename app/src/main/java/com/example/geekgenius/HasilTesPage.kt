package com.example.geekgenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HasilTesPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_page)

        val kecerdasan = intent.getStringExtra("KECERDASAN")
        val jurusan = intent.getStringExtra("JURUSAN")

        val txtKecerdasan = findViewById<TextView>(R.id.txtKecerdasan)
        val txtJurusan = findViewById<TextView>(R.id.txtJurusan)

        txtKecerdasan.text = "Kecerdasan: $kecerdasan"
        txtJurusan.text = "Jurusan yang cocok: $jurusan"

        val btnSelesai: Button = findViewById(R.id.btnSelesai)
        btnSelesai.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            startActivity(intent)
        }
    }
}