package com.example.practical

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Weather1 : AppCompatActivity() {

    private var maxTempList = arrayListOf<Int>()
    private var minTempList = arrayListOf<Int>()
    private var daysList = arrayListOf<String>()
    private var weatherConditionsList = arrayListOf<String>()

    @SuppressLint("WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        val dayEditText = findViewById<EditText>(R.id.days)
        val maxTempEditText = findViewById<EditText>(R.id.max1)
        val minTempEditText = findViewById<EditText>(R.id.min)
        val weatherConditionEditText = findViewById<EditText>(R.id.weather)
        val averageButton = findViewById<Button>(R.id.button)
        val averageTextView = findViewById<TextView>(R.id.textView9)
        val clearButton = findViewById<Button>(R.id.clear)
        val exitButton = findViewById<Button>(R.id.ExitButton)

        averageButton.setOnClickListener {
            val day = dayEditText.text.toString()
            val maxTemp = maxTempEditText.text.toString().toIntOrNull()
            val minTemp = minTempEditText.text.toString().toIntOrNull()
            val condition = weatherConditionEditText.text.toString()

            if (day.isNotEmpty() && maxTemp != null && minTemp != null && condition.isNotEmpty()) {
                daysList.add(day)
                maxTempList.add(maxTemp)
                minTempList.add(minTemp)

                val averageMaxTemp = maxTempList.sum() / maxTempList.size
                val averageMinTemp = minTempList.sum() / minTempList.size

                averageTextView.text =
                    "Average Max Temp: $averageMaxTemp\nAverage Min Temp: $averageMinTemp"

                // Clear input fields after adding the data
                dayEditText.text.clear()
                maxTempEditText.text.clear()
                minTempEditText.text.clear()
                weatherConditionEditText.text.clear()
            } else {
                averageTextView.text = "Please fill in all fields"
            }
        }

        clearButton.setOnClickListener {
            // Clear all input fields
            dayEditText.text.clear()
            maxTempEditText.text.clear()
            minTempEditText.text.clear()
            weatherConditionEditText.text.clear()
        }

        exitButton.setOnClickListener {
            finishAffinity() // Exit the app entirely
        }

        val viewDetailsButton = findViewById<Button>(R.id.Detail)
        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, Screen2::class.java)
            intent.putStringArrayListExtra("Days", daysList)
            intent.putIntegerArrayListExtra("MaxTemps", maxTempList)
            intent.putIntegerArrayListExtra("MinTemps", minTempList)
            intent.putStringArrayListExtra("WeatherConditions", weatherConditionsList)
            startActivity(intent)
        }
    }
}