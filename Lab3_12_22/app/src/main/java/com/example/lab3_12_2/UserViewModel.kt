package com.example.lab3_12_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val userList = ApiClient.apiService.getUsers()
                _users.postValue(userList)
            } catch (e: Exception) {
                // Handle error (optional)
                _users.postValue(emptyList())
            }
        }
    }
}
