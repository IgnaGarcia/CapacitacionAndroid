package com.example.sample.sample2.local

import android.content.Context

object SharedPreferencesManager{
    private const val PREFERENCES_NAME = "MyPreferences"
    private const val USER_KEY = "user"

    fun getPreferences(context: Context) =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun saveUser(context: Context, user: String) {
        getPreferences(context)
            .edit()
            .putString(USER_KEY, user)
            .apply()
    }

    fun getUser(context: Context): String? {
        val user = getPreferences(context)
            .getString(USER_KEY, "")
        return user
    }

    fun clearData(context: Context) {
        getPreferences(context).edit().clear().apply()
    }
}