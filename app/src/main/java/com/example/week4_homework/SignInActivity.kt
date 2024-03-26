package com.example.week4_homework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var loginBtn: Button
    private lateinit var joinBtn: Button
    private lateinit var idET: EditText
    private lateinit var passwordET: EditText
    private lateinit var startForResult: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        loginBtn = findViewById(R.id.btn_login)
        joinBtn = findViewById(R.id.btn_join)
        idET = findViewById(R.id.et_id)
        passwordET = findViewById(R.id.et_password)

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val id = result.data?.getStringExtra("signed_id")
                    val password = result.data?.getStringExtra("signed_password")
                    idET.setText(id)
                    passwordET.setText(password)
                }
            }

        loginBtn.setOnClickListener { loginBtnClickListener() }
        joinBtn.setOnClickListener { joinBtnClickListener() }
    }

    private fun joinBtnClickListener() {
        val intent = Intent(this, SignUpActivity::class.java)
        startForResult.launch(intent)
    }

    private fun loginBtnClickListener() {
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
}