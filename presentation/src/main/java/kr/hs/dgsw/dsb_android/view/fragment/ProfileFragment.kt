package kr.hs.dgsw.dsb_android.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.dsb_android.R
import kr.hs.dgsw.dsb_android.base.BaseFragment
import kr.hs.dgsw.dsb_android.databinding.FragmentHomeBinding
import kr.hs.dgsw.dsb_android.databinding.FragmentProfileBinding
import kr.hs.dgsw.dsb_android.viewmodel.fragment.ProfileViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val viewModel: ProfileViewModel by viewModels()

    override fun observerViewModel() {
        with(mViewModel) {
            onClickAccountListEvent.observe(this@ProfileFragment, {
                findNavController().navigate(R.id.action_profile_to_accountListFragment)
            })
            onClickPrivacyPolicyEvent.observe(this@ProfileFragment, {
                findNavController().navigate(R.id.action_profile_to_privacyPolicyFragment)
            })
        }
    }


}