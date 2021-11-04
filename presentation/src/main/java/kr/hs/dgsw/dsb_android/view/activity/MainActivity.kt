package kr.hs.dgsw.dsb_android.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kr.hs.dgsw.dsb_android.R
import kr.hs.dgsw.dsb_android.base.BaseActivity
import kr.hs.dgsw.dsb_android.databinding.ActivityMainBinding
import kr.hs.dgsw.dsb_android.viewmodel.activity.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    lateinit var host : NavHostFragment

    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        host = supportFragmentManager.findFragmentById(R.id.fragment_layout) as NavHostFragment
        mBinding.navBottom.setupWithNavController(host.navController)
    }
}