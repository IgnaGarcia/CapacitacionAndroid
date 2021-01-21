package com.example.clase201

class User(var name : String = "",
           var surname : String = "",
           var age : String? ="n/a"){

}

fun getPlaceholderUsers() : List<User> {
    return listOf(User("Steve", "Xlen"),
        User("Dose", "Xlen"),
        User("Tres", "Xlen", "18"),
        User("Cuatro", "Xlen"),
        User("Cinco", "Xlen", "11"),
        User("Seis", "Xlen"),
        User("Siete", "Xlen"),
        User("Dose", "Xlen", "31"))
}