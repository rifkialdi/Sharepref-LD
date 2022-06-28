package com.example.sharepref_ld.helper

import android.content.Context
import android.content.SharedPreferences

class Helper(val context: Context) {
    private val sharePref: SharedPreferences
    private val editor: SharedPreferences.Editor
    private val PREFS_NAME = "kEY_SHAREPREF"

    init {
        sharePref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharePref.edit()
    }

    fun putString(key: String, value: String) {
        editor.putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return sharePref.getString(key, null)
    }

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharePref.getBoolean(key, false)
    }

    fun clearr() {
        editor.clear().apply()
    }
}