package com.example.week4_homework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val loginBtn = findViewById<Button>(R.id.btn_login)
        val joinBtn = findViewById<Button>(R.id.btn_join)
        val idET = findViewById<EditText>(R.id.et_id)
        val passwordET = findViewById<EditText>(R.id.et_password)
        loginBtn.setOnClickListener {
            val intent = Intent()
        }
        joinBtn.setOnClickListener {
            val intent = Intent()
        }

    }
}