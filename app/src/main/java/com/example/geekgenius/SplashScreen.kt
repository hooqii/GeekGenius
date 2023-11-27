package com.example.geekgenius

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    private val splashTimeOut: Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed(splashTimeOut) {
            navigateToWelcomePage()
        }
    }

    private fun navigateToWelcomePage() {
        val mainIntent = Intent(this@SplashScreen, WellcomePage::class.java)
        startActivity(mainIntent)
        finish()
    }

    // Extension function for Handler
    private fun Handler.postDelayed(delayMillis: Long, action: () -> Unit) {
        postDelayed(action, delayMillis)
    }
}
