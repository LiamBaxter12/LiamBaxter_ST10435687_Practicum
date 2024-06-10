package com.example.practical

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.viewWeather)
        val exit = findViewById<Button>(R.id.exit)

        button1.setOnClickListener {
            val intent = Intent(this, Weather1::class.java)
            startActivity(intent)
        }

        exit.setOnClickListener {
            finishAffinity() // Exit the app entirely
        }
    }
}
