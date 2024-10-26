package com.example.lab3_12_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Danh sách các URL hình ảnh
        val imageUrls = listOf(
            "https://via.placeholder.com/600/92c952",
            "https://via.placeholder.com/600/771796",
            "https://via.placeholder.com/600/24f355",
            "https://via.placeholder.com/600/f66b97",
            // Thêm nhiều URL khác
        )
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cài đặt adapter cho RecyclerView
        imageAdapter = ImageAdapter(imageUrls)
        recyclerView.adapter = imageAdapter
    }
}
