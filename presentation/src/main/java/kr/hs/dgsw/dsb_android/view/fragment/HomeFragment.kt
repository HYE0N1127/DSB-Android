package kr.hs.dgsw.dsb_android.view.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kr.hs.dgsw.dsb_android.base.BaseFragment
import kr.hs.dgsw.dsb_android.databinding.FragmentHomeBinding
import kr.hs.dgsw.dsb_android.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }

}