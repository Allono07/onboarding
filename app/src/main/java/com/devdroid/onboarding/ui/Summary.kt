package com.devdroid.onboarding.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.devdroid.onboarding.R

class Summary: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.summary)

        val closeButton = findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        val answers = intent.getSerializableExtra("answers") as? Map<String, String>
        if (answers != null) {
            displaySummary(answers)
        } else {
            // Handle no answers passed
        }
    }

    private fun displaySummary(answers: Map<String, String>) {
        val summaryText = buildString {
            for ((question, answer) in answers) {
                append("$question: $answer\n")
            }
        }
        val summaryTextView = findViewById<TextView>(R.id.summaryTextView)
        summaryTextView.text = summaryText
    }
}
