package kr.hs.dgsw.dsb_android

import android.app.Application
import org.koin.core.context.startKoin

class DSBApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            val module = listOf(

            )
        }
    }

}