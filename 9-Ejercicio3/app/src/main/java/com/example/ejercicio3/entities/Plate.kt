package com.example.ejercicio3.entities

import android.os.Parcel
import android.os.Parcelable
import com.example.ejercicio3.network.responses.ExtendedIngredient

data class Plate(val id: Int,
                 val image: String?,
                 val glutenFree: Boolean,
                 val cuisines: List<String>?,
                 val dairyFree: Boolean,
                 val extendedIngredients: List<ExtendedIngredient>,
                 val pricePerServing: Double,
                 val title: String?,
                 val spoonacularScore: Double,
                 val readyInMinutes: Int,
                 val sourceName: String?,
                 val cheap: Boolean,

                 var isFavourite : Boolean = false,
                 var hasFreeDelivery : Boolean = false) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.createStringArrayList(),
            parcel.readByte() != 0.toByte(),
            listOf<ExtendedIngredient>().apply {
                parcel.readTypedList(this, ExtendedIngredient.CREATOR)
            },
            parcel.readDouble(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(image)
        parcel.writeByte(if (glutenFree) 1 else 0)
        parcel.writeStringList(cuisines)
        parcel.writeByte(if (dairyFree) 1 else 0)
        parcel.writeTypedList(extendedIngredients)
        parcel.writeDouble(pricePerServing)
        parcel.writeString(title)
        parcel.writeDouble(spoonacularScore)
        parcel.writeInt(readyInMinutes)
        parcel.writeString(sourceName)
        parcel.writeByte(if (cheap) 1 else 0)
        parcel.writeByte(if (isFavourite) 1 else 0)
        parcel.writeByte(if (hasFreeDelivery) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plate> {
        override fun createFromParcel(parcel: Parcel): Plate {
            return Plate(parcel)
        }

        override fun newArray(size: Int): Array<Plate?> {
            return arrayOfNulls(size)
        }
    }
}