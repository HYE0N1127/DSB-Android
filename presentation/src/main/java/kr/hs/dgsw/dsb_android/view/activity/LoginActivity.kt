package kr.hs.dgsw.dsb_android.view.activity

import android.content.Intent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.dsb_android.base.BaseActivity
import kr.hs.dgsw.dsb_android.databinding.ActivityLoginBinding
import kr.hs.dgsw.dsb_android.viewmodel.activity.LoginViewModel

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(){
    override val viewModel: LoginViewModel by viewModels()

    override fun observerViewModel() {
        with(mViewModel) {
            onRegisterClickEvent.observe(this@LoginActivity, {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            })
            loginSuccessEvent.observe(this@LoginActivity, {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
        }
    }

}