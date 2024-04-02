package com.example.week4_homework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
//testasd

class SignInActivity : AppCompatActivity() {

    private val loginBtn: Button by lazy{
        findViewById(R.id.btn_login)
    }
    private val joinBtn: Button by lazy{
        findViewById(R.id.btn_join)
    }
    private val idET: EditText by lazy {
        findViewById(R.id.et_id)
    }
    private val passwordET: EditText by lazy {
        findViewById(R.id.et_password)
    }
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        init()

        loginBtn.setOnClickListener { loginBtnOnClick() }
        joinBtn.setOnClickListener { joinBtnOnClick() }
    }

    private fun joinBtnOnClick() {
        val intent = Intent(this, SignUpActivity::class.java)
        startForResult.launch(intent)
    }

    private fun loginBtnOnClick() {
        if (idET.text.isEmpty() || passwordET.text.isEmpty()) {
            toastFun(this, "아이디/비밀번호를 확인해주세요.")
        } else {
            val intent = Intent(this, HomeActivity::class.java)
            intent.apply {
                putExtra("extra_id", idET.text.toString())
                putExtra("random", getRandomIndex())
            }
            toastFun(this, "로그인 성공")
            startActivity(intent)
        }
    }

    private fun init(){
        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val id = result.data?.getStringExtra("signed_id")
                val password = result.data?.getStringExtra("signed_password")
                idET.setText(id)
                passwordET.setText(password)
            }
        }
    }
}