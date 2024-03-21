package com.example.week4_homework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val nameET = findViewById<EditText>(R.id.et_name_sign_up)
        val idET = findViewById<EditText>(R.id.et_id_sign_up)
        val passwordET = findViewById<EditText>(R.id.et_password_sign_up)
        val signUpBtn = findViewById<Button>(R.id.btn_sign_up)

        signUpBtn.setOnClickListener {
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
}