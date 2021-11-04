package kr.hs.dgsw.dsb_android.view.fragment

import androidx.fragment.app.viewModels
import kr.hs.dgsw.dsb_android.base.BaseFragment
import kr.hs.dgsw.dsb_android.databinding.FragmentHomeBinding
import kr.hs.dgsw.dsb_android.viewmodel.fragment.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {
        with(mViewModel) {
            mBinding.homeRefreshLayout.setOnRefreshListener {

            }
        }
    }
}