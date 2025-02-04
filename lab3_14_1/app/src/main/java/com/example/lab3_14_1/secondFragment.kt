// ui/SecondFragment.kt
package com.example.lab3_14_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SecondFragment : Fragment() {
    private val cartProducts = managerProduct.getCart()// Giỏ hàng tạm thời

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.cart_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProductAdapter(cartProducts) { /* Xử lý click nếu cần */ }

        return view
    }
}
