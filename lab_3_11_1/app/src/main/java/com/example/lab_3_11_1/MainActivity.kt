package com.example.lab_3_11_1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val textEmail:TextView = findViewById(R.id.Email)
        val textNumber:TextView = findViewById(R.id.numberPhone)
        val buttonSubmit: Button = findViewById(R.id.btnSubmit)

        buttonSubmit.setOnClickListener {

            val textRev = findViewById<TextView>(R.id.exRe)
            val emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
            val phonePattern = "0\\d{8,11}"

            if(!textEmail.text.matches(Regex(emailRegex))){
                textRev.text = "Email không hợp le"
            }
            else if(!textNumber.text.matches(Regex(phonePattern))){
                textRev.text = "Số điện thoại không hợp le"
            }else{
                textRev.text = "Chúc mừng thành công"
            }
        }

    }
}