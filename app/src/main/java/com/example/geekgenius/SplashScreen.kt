package com.example.geekgenius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIMEOUT: Long = 2500 // Waktu tampilan splash screen dalam milidetik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val mainIntent = Intent(this@SplashScreen, WellcomePage::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_TIMEOUT)
    }
}