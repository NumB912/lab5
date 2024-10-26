// ui/FirstFragment.kt
package com.example.lab3_14_1

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.snackbar.Snackbar

class FirstFragment : Fragment() {
    private val products = listOf(
        Product(1, "Product 1"),
        Product(2, "Product 2"),
        Product(3, "Product 3")
    )
    private val cart = mutableListOf<Product>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProductAdapter(products) { product ->
            showAddToCartDialog(product)
        }

        val viewCartButton: Button = view.findViewById(R.id.view_cart_button)
        viewCartButton.setOnClickListener {
            // Điều hướng tới SecondFragment
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }

    private fun showAddToCartDialog(product: Product) {
        AlertDialog.Builder(requireContext())
            .setTitle("Add to Cart")
            .setMessage("Do you want to add ${product.name} to cart?")
            .setPositiveButton("Yes") { dialog, _ ->
                // Thêm sản phẩm vào giỏ hàng (logic tùy chọn)
                managerProduct.addCart(product)
                Snackbar.make(requireView(), "Product added to cart", Snackbar.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}
