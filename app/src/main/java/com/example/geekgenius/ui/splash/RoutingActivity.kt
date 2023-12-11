package com.geek.app.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.geekgenius.R
import com.geek.app.ui.main.MainActivity
//import com.geek.app.ui.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RoutingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routing)

        lifecycleScope.launch {
            delay(2500L)
            val intent = Intent(this@RoutingActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}