package com.example.lab3_12_2
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private val TAG = "MainActivity"
    lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Observe the user data
        userViewModel.users.observe(this, Observer { users ->
            userAdapter = UserAdapter(users)
            recyclerView.adapter = userAdapter
        })

        // Fetch users
        userViewModel.fetchUsers()
    }
}
