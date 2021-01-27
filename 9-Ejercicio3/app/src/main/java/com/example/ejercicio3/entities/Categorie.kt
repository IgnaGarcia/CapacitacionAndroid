package com.example.ejercicio3.entities

import android.graphics.drawable.Drawable
import com.example.ejercicio3.App
import com.example.ejercicio3.R

class Categorie(
    val text: String,
    val icon: Drawable
)

public fun getCategories() : List<Categorie> {
    return listOf(Categorie(App.instance.getString(R.string.favourites), App.instance.getDrawable(R.drawable.ic_favorite)!!),
        Categorie(App.instance.getString(R.string.offers), App.instance.getDrawable(R.drawable.ic_offer)!!),
        Categorie(App.instance.getString(R.string.trends), App.instance.getDrawable(R.drawable.ic_trend)!!),
        Categorie(App.instance.getString(R.string.more), App.instance.getDrawable(R.drawable.ic_more)!!))
}