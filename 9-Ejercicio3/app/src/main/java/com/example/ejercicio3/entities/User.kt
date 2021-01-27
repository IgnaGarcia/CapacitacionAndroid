package com.example.ejercicio3.entities

data class User(
        val username: String,
        val name: String,
        val surname: String,
        var age: Int,
        val email: String,
        val location: String?
)