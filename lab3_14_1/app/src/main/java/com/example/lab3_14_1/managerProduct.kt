package com.example.lab3_14_1

object managerProduct {
    val cart_product= mutableListOf<Product>()


    fun addCart(product:Product){
        cart_product.add(product)
    }

    fun getCart():MutableList<Product>{
        return cart_product
    }
}