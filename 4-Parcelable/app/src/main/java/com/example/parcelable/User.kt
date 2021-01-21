package com.example.ejercitacion2

import android.os.Parcel
import android.os.Parcelable

data class User(val name : String,
                val surname : String,
                val username : String,
                val mail : String,
                var password : String) : Parcelable {

    constructor(parcel: Parcel) : this(
        name = parcel.readString()!!,
        surname = parcel.readString()!!,
        username = parcel.readString()!!,
        mail = parcel.readString()!!,
        password = parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(surname)
        parcel.writeString(username)
        parcel.writeString(mail)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}