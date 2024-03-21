package com.example.week4_homework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    lateinit var startForResult: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val loginBtn = findViewById<Button>(R.id.btn_login)
        val joinBtn = findViewById<Button>(R.id.btn_join)
        val idET = findViewById<EditText>(R.id.et_id)
        val passwordET = findViewById<EditText>(R.id.et_password)

        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                val id = result.data?.getStringExtra("signed_id")
                val password = result.data?.getStringExtra("signed_password")
                idET.setText(id)
                passwordET.setText(password)
            }
        }

        loginBtn.setOnClickListener {
            if(idET.text.isEmpty() || passwordET.text.isEmpty()){
                toastFun(this,"아이디/비밀번호를 확인해주세요.")
            }else {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.apply{
                    putExtra("extra_id", idET.text.toString())
                    putExtra("random", getRandomIndex())
                }
                toastFun(this, "로그인 성공")
                startActivity(intent)
            }
        }
        joinBtn.setOnClickListener {
            val intent = Intent(applicationContext, SignUpActivity::class.java)
            startForResult.launch(intent)
        }

    }
}