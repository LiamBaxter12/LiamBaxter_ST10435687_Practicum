package com.example.practical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        val detailsTextView = findViewById<TextView>(R.id.textView2)

        val daysList = intent.getStringArrayListExtra("Days") ?: arrayListOf()
        val maxTempList = intent.getIntegerArrayListExtra("MaxTemps") ?: arrayListOf()
        val minTempList = intent.getIntegerArrayListExtra("MinTemps") ?: arrayListOf()
        val weatherConditionsList = intent.getStringArrayListExtra("WeatherConditions") ?: arrayListOf()

        val details = StringBuilder()
        for (i in daysList.indices) {
            details.append("Day: ${daysList[i]}, Max Temp: ${maxTempList[i]}, Min Temp: ${minTempList[i]}, Condition: ${weatherConditionsList[i]}\n")
        }

        detailsTextView.text = details.toString()

        val backButton = findViewById<Button>(R.id.BackButton2)
        backButton.setOnClickListener {
            finish() // Navigate back to previous activity (Weather1)
        }
    }
}