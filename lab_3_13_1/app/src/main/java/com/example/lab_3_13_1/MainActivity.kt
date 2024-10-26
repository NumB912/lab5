package com.example.lab_3_13_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var buttonCheck: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        buttonCheck = findViewById(R.id.buttonCheck)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCheck.setOnClickListener { checkNumber() }
    }

    private fun checkNumber() {
        val number = editTextNumber.text.toString().toIntOrNull()
        textViewResult.text = when {
            number == null -> "Please enter a valid number"
            number % 2 == 0 -> "Even Number"
            else -> "Odd Number"
        }
    }
}
