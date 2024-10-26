package com.example.lab3_12_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val users: List<User>) :
RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       val user = users[position]
        holder.nameTextView.text = user.name

        Glide.with(holder.itemView.context)
            .load("https://i.pravatar.cc/150?u=${user.id}")
            .placeholder(R.drawable.placeholder)
            .into(holder.avatarImageView)
    }
    override fun getItemCount(): Int {
        return users.size
    }
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val avatarImageView:ImageView = itemView.findViewById(R.id.avatarImageView)


    }
}
