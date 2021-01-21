package com.example.clase201

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SampleItem : AppCompatActivity() {
    var usersAdapter : UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList = getPlaceholderUsers()

        val rvUser = findViewById<RecyclerView>(R.id.rvUser)

        usersAdapter = UsersAdapter(userList)

        rvUser.adapter = usersAdapter
        rvUser.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)
    }
}