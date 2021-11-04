package kr.hs.dgsw.data.database

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager.getDefaultSharedPreferencesName
import io.reactivex.Completable
import io.reactivex.Single

class TokenCache {

    fun getToken(context: Context) : String? {
        return getDefaultSharedPreferences(context).getString("token", null)
    }

    fun setToken(context: Context, token: String) {
        getDefaultSharedPreferences(context).edit().putString("token", token).apply()
    }

    fun deleteToken() : Completable {
        Preferences.preferences.edit().remove("token").remove("easyPwIdx").apply()
        return Completable.complete()
    }

    private fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
            getDefaultSharedPreferencesMode())
    }

    private fun getDefaultSharedPreferencesName(context: Context): String {
        return context.packageName.toString() + "_preferences"
    }

    private fun getDefaultSharedPreferencesMode(): Int {
        return Context.MODE_PRIVATE
    }
}