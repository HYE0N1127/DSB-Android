package kr.hs.dgsw.dsb_android

import android.app.Application
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.dsb_android.module.*
import org.koin.core.context.startKoin
import org.koin.dsl.module

class DSBApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            val module = listOf(
                NetworkModule,
                RemoteModule,
                RepositoryModule,
                ServiceModule,
                ViewModelModule,
                UseCaseModule
            )

            modules(module)
        }
    }

}