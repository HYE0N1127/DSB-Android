package kr.hs.dgsw.dsb_android.ui.login

import android.content.Intent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.dsb_android.ui.register.detail.RegisterActivity
import kr.hs.dgsw.dsb_android.base.BaseActivity
import kr.hs.dgsw.dsb_android.databinding.ActivityLoginBinding
import kr.hs.dgsw.dsb_android.ui.main.MainActivity

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(){
    override val viewModel: LoginViewModel by viewModels()

    override fun observerViewModel() {
        with(mViewModel) {
            onRegisterClickEvent.observe(this@LoginActivity, {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            })
            onLoginClickEvent.observe(this@LoginActivity, {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            })
        }
    }

}