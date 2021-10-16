package kr.hs.dgsw.dsb_android.ui.register.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import kr.hs.dgsw.dsb_android.base.BaseActivity
import kr.hs.dgsw.dsb_android.databinding.ActivityRegisterBinding
import kr.hs.dgsw.dsb_android.ui.login.LoginActivity

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