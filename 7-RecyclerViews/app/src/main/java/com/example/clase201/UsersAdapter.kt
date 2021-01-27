package com.example.clase201

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

//on clickuser es cb para enviar el intent al detalle
//Glide y Picasso para cargar imagenes
class UsersAdapter(var users : List<User>, var onClickUser : OnClickUser) : RecyclerView.Adapter<UsersAdapter.BaseViewHolder>(){

    inner class BaseViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvType = view.findViewById<TextView>(R.id.tvType)
        val tvIsSiteAdmin = view.findViewById<TextView>(R.id.tvIsSiteAdmin)
        val ivProfile = view.findViewById<ImageView>(R.id.ivProfile)
        //cargar imagen aca tambien si la hubiera

        fun onBind(user : User){
            tvName.text = user.login
            tvType.text = user.type
            tvIsSiteAdmin.text = if(user.siteAdmin) "Es admin" else "No es admin"

            Glide.with(ivProfile.context).load(user.avatarUrl)
                    .circleCrop().into(ivProfile)

            //evento dentro de un recycler
            itemView.setOnClickListener{
                onClickUser.onClickUser(user.login)
            }
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

    interface OnClickUser{
        fun onClickUser(username : String)
    }
}