package kr.hs.dgsw.dsb_android.view.activity

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import kr.hs.dgsw.dsb_android.base.BaseActivity
import kr.hs.dgsw.dsb_android.databinding.ActivityLoginBinding
import kr.hs.dgsw.dsb_android.viewmodel.activity.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(){

    override val viewModel: LoginViewModel
        get() = getViewModel(clazz = LoginViewModel::class)



    override fun observerViewModel() {
        with(mViewModel) {
            onRegisterClickEvent.observe(this@LoginActivity, {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            })
            loginSuccessEvent.observe(this@LoginActivity, {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            })
            inputEmptyEvent.observe(this@LoginActivity, {
                Toast.makeText(this@LoginActivity, "Check ID or Password", Toast.LENGTH_SHORT).show()
            })
        }
    }

}