package com.example.geekgenius

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailKampusPage : AppCompatActivity() {

    companion object {
        const val EXTRA_LOGO_ID = "extra_logo_id"
    }

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kampus_page)

        database = FirebaseDatabase.getInstance().reference.child("kampuses")

        val imageView: ImageView = findViewById(R.id.ivLogoKampus)
        val btnBack: Button = findViewById(R.id.btnBack)

        val logoId = intent.getIntExtra(EXTRA_LOGO_ID, 0)
        if (logoId != 0) {
            imageView.setImageResource(logoId)
        }

        btnBack.setOnClickListener {
            finish()
        }

//         Example: Writing data to Firebase
        val kampusId = "ui" // Use a unique identifier for each campus
        val kampusRef = database.child(kampusId)
        kampusRef.child("logoId").setValue(logoId)
    }
}
