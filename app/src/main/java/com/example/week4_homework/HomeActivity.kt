package com.example.week4_homework

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val idValueTV = findViewById<TextView>(R.id.tv_id_value_home)
        val nameValueTV = findViewById<TextView>(R.id.tv_name_value_home)
        val mbtiValueTV = findViewById<TextView>(R.id.tv_mbti_value_home)
        val hobbyValueTV = findViewById<TextView>(R.id.tv_hobby_value_home)
        val finishBtn = findViewById<Button>(R.id.btn_finish)


        finishBtn.setOnClickListener {
            finish()
        }


    }
}