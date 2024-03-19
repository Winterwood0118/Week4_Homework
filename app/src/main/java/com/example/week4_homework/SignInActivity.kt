package com.example.week4_homework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
            if(idET.text.isEmpty() || passwordET.text.isEmpty()){
                Toast.makeText(this,"아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("EXTRA_ID", idET.text.toString())
                Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
                //passwordET.text.clear()
                startActivity(intent)
            }
        }
        joinBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}