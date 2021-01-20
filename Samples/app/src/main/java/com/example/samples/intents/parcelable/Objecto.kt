package com.example.samples.intents.parcelable

import android.os.Parcel
import android.os.Parcelable

class Objecto(val name : String?,
            val pass : String?): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(pass)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Objecto> {
        override fun createFromParcel(parcel: Parcel): Objecto {
            return Objecto(parcel)
        }

        override fun newArray(size: Int): Array<Objecto?> {
            return arrayOfNulls(size)
        }
    }
}