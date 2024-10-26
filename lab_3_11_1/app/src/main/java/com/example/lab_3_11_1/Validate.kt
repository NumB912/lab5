package com.example.lab_3_11_1

import java.math.BigInteger

object Validate{

    val emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
    val phonePattern = "0\\d{8,11}"

    fun checkEmail(yourEmail:String):Boolean{
        return yourEmail.matches(Regex(emailRegex))
    }

    fun checkNumberPhone(numberPhone:String):Boolean{
        return numberPhone.matches(Regex(phonePattern))
    }



}