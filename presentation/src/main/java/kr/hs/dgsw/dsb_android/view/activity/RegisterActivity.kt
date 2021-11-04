package kr.hs.dgsw.dsb_android.view.activity

import android.content.Intent
import androidx.activity.viewModels
import kr.hs.dgsw.dsb_android.base.BaseActivity
import kr.hs.dgsw.dsb_android.databinding.ActivityRegisterBinding
import kr.hs.dgsw.dsb_android.viewmodel.activity.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {
    override val viewModel: RegisterViewModel by viewModels()

    override fun observerViewModel() {
        with(mViewModel) {
            registerEvent.observe(this@RegisterActivity, {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            })
        }
    }
}