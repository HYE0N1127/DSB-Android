package kr.hs.dgsw.data.database

import android.content.Context
import android.content.SharedPreferences

object Preferences {
    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }
}