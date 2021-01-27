package com.example.ejercicio3.network.responses

import android.os.Parcel
import android.os.Parcelable

data class ExtendedIngredient(
        val aisle: String?,
        val amount: Double,
        val consistency: String?,
        val id: Int,
        val image: String?,
        val name: String?,
        val original: String?,
        val originalName: String?,
        val originalString: String?,
        val unit: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(aisle)
        parcel.writeDouble(amount)
        parcel.writeString(consistency)
        parcel.writeInt(id)
        parcel.writeString(image)
        parcel.writeString(name)
        parcel.writeString(original)
        parcel.writeString(originalName)
        parcel.writeString(originalString)
        parcel.writeString(unit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExtendedIngredient> {
        override fun createFromParcel(parcel: Parcel): ExtendedIngredient {
            return ExtendedIngredient(parcel)
        }

        override fun newArray(size: Int): Array<ExtendedIngredient?> {
            return arrayOfNulls(size)
        }
    }


}
