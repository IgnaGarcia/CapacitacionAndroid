package com.example.clase201

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter(var users : List<User>) : RecyclerView.Adapter<UsersAdapter.BaseViewHolder>(){

    class BaseViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvSurname = view.findViewById<TextView>(R.id.tvSurname)
        val tvAge = view.findViewById<TextView>(R.id.tvAge)
        //cargar imagen aca tambien si la hubiera

        fun onBind(user : User){
            tvName.text = user.name
            tvSurname.text = user.surname
            tvAge.text = user.age
            //controles aca, es cuando se manda a la vista
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.BaseViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersAdapter.BaseViewHolder, position: Int) {
        holder.onBind(users[position])
    }

    override fun getItemCount(): Int = users.size
}