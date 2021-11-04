package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.dsb_android.viewmodel.activity.LoginViewModel
import kr.hs.dgsw.dsb_android.viewmodel.fragment.HomeViewModel
import kr.hs.dgsw.dsb_android.viewmodel.activity.MainViewModel
import kr.hs.dgsw.dsb_android.viewmodel.activity.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    // activity
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel() }
    viewModel { MainViewModel() }

    // Fragment
    viewModel { HomeViewModel() }
}