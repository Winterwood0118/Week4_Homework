package com.example.week4_homework

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val mainIV = findViewById<ImageView>(R.id.iv_logo)
        val idValueTV = findViewById<TextView>(R.id.tv_id_value_home)
        val nameValueTV = findViewById<TextView>(R.id.tv_name_value_home)
        val mbtiValueTV = findViewById<TextView>(R.id.tv_mbti_value_home)
        val hobbyValueTV = findViewById<TextView>(R.id.tv_hobby_value_home)
        val finishBtn = findViewById<Button>(R.id.btn_finish)
        var randomNum = intent.getIntExtra("random", 1)
        var imageResource = imageResources[randomNum]

        idValueTV.text = intent.getStringExtra("extra_id")
        mainIV.setImageResource(imageResource)

        //사진 누르면 바꾸기 기능 추가해봄
        mainIV.setOnClickListener{
            randomNum = (0..4).filter { it != randomNum }.random()
            imageResource = imageResources[randomNum]
            mainIV.setImageResource(imageResource)
        }

        finishBtn.setOnClickListener {
            finish()
        }


    }
}