package kr.hs.dgsw.dsb_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kr.hs.dgsw.data.database.Preferences

@HiltAndroidApp
class DSBApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Preferences.init(this)
    }

}