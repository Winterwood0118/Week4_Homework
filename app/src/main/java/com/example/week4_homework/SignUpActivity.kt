package com.example.week4_homework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    private val nameET: EditText by lazy {
        findViewById(R.id.et_name_sign_up)
    }
    private val idET: EditText by lazy {
        findViewById(R.id.et_id_sign_up)
    }
    private val passwordET: EditText by lazy {
        findViewById(R.id.et_password_sign_up)
    }
    private val signUpBtn: Button by lazy {
        findViewById(R.id.btn_sign_up)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpBtn.setOnClickListener { signUpOnClick() }
    }

    private fun signUpOnClick() {
        if (nameET.text.isEmpty() || idET.text.isEmpty() || passwordET.text.isEmpty()) {
            toastFun(applicationContext, "입력되지 않은 정보가 있습니다.")
        } else {
            val intent = Intent().apply {
                putExtra("signed_id", idET.text.toString())
                putExtra("signed_password", passwordET.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}