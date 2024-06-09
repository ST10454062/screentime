package com.example.st10454062.screentime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val dates = intent.getStringArrayListExtra("dates") ?: arrayListOf()
        val morningScreenTimes = intent.getIntegerArrayListExtra("morningScreenTimes") ?: arrayListOf()
        val afternoonScreenTimes = intent.getIntegerArrayListExtra("afternoonScreenTimes") ?: arrayListOf()
        val activityNotes = intent.getStringArrayListExtra("activityNotes") ?: arrayListOf()

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        val averageScreenTimeTextView = findViewById<TextView>(R.id.averageScreenTimeTextView)
        val backButton = findViewById<Button>(R.id.backButton)
        var totalScreenTime = 0
        var displayText = ""
        for (i in dates.indices) {
            val dailyScreenTime = morningScreenTimes[i] + afternoonScreenTimes[i]
            totalScreenTime += dailyScreenTime
            displayText += "Date: ${dates[i]}, Morning: ${morningScreenTimes[i]} min, Afternoon: ${afternoonScreenTimes[i]} min, Notes: ${activityNotes[i]}\n\n"
        }
        val averageScreenTime = if (dates.isNotEmpty()) totalScreenTime / dates.size else 0
        detailsTextView.text = displayText
        averageScreenTimeTextView.text = "Average Screen Time: $averageScreenTime minutes/day"

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}