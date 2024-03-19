package com.example.week4_homework

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
            finish()
        }
    }
}