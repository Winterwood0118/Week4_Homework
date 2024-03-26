package com.example.week4_homework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var nameET: EditText
    private lateinit var idET: EditText
    private lateinit var passwordET: EditText
    private lateinit var signUpBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        nameET = findViewById(R.id.et_name_sign_up)
        idET = findViewById(R.id.et_id_sign_up)
        passwordET = findViewById(R.id.et_password_sign_up)
        signUpBtn = findViewById(R.id.btn_sign_up)

        signUpBtn.setOnClickListener { signUpClickListener() }
    }

    private fun signUpClickListener() {
        if (nameET.text.isEmpty() || idET.text.isEmpty() || passwordET.text.isEmpty()) {
            toastFun(applicationContext, "입력되지 않은 정보가 있습니다.")
        } else {
            //데이터 저장 추가한다면 여기에 작성
            val intent = Intent().apply {
                putExtra("signed_id", idET.text.toString())
                putExtra("signed_password", passwordET.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}