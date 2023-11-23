package com.example.geekgenius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent


class WellcomePage : AppCompatActivity() {

    //Binding
//    private lateinit var binding :

    private lateinit var btnLoginGoogle : Button
    private lateinit var btnLoginEmail : Button
    private lateinit var textLinkRegister : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wellcome_page)

        btnLoginGoogle = findViewById(R.id.btnLoginGoogle)
        btnLoginEmail = findViewById(R.id.btnLoginEmail)

        btnLoginEmail.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }

    }
}