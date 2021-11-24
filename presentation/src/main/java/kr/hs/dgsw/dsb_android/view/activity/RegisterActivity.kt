package kr.hs.dgsw.dsb_android.view.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import kr.hs.dgsw.dsb_android.base.BaseActivity
import kr.hs.dgsw.dsb_android.databinding.ActivityRegisterBinding
import kr.hs.dgsw.dsb_android.viewmodel.activity.LoginViewModel
import kr.hs.dgsw.dsb_android.viewmodel.activity.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.io.File

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {

    override val viewModel: RegisterViewModel
        get() = getViewModel(clazz = RegisterViewModel::class)

    override fun observerViewModel() {
        with(mViewModel) {
            registerEvent.observe(this@RegisterActivity, {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            })
            picProfileImageEvent.observe(this@RegisterActivity, {
                val intent =
                    Intent().setType("image/*").putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                        .setAction(Intent.ACTION_PICK)
                getContent.launch(intent)
            })
            registerSuccessEvent.observe(this@RegisterActivity, {
                Toast.makeText(this@RegisterActivity, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            })

            if (idDoubleValidEvent.value == true) {
                Toast.makeText(this@RegisterActivity, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            it.data?.clipData?.apply {
            }
        }
    }

    private fun getRealPathFromURI(uri: Uri): Uri {
        val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = this.contentResolver.query(uri, filePathColumn, null, null, null)
        cursor?.moveToFirst()

        val columnIndex = cursor?.getColumnIndex(filePathColumn[0])
        val picturePath = columnIndex?.let { cursor.getString(it) }
        cursor?.close()

        return Uri.fromFile(File(picturePath ?: ""))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.etPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())
    }
}