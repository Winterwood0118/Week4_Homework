package com.example.week4_homework

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    private val mainIV: ImageView by lazy {
        findViewById(R.id.iv_logo)
    }
    private val idValueTV: TextView by lazy {
        findViewById(R.id.tv_id_value_home)
    }
    private val finishBtn: Button by lazy {
        findViewById(R.id.btn_finish)
    }
    private var randomNum = 0
    private var imageResource = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()

        mainIV.setOnClickListener { mainImageOnClick() }
        finishBtn.setOnClickListener { finishOnClick() }
    }

    private fun finishOnClick() {
        finish()
    }

    private fun mainImageOnClick() {
        mainIV.setOnClickListener {
            randomNum = getRandomIndex()
            imageResource = imageResources[randomNum]
            mainIV.setImageResource(imageResource)
        }
    }

    private fun init() {
        randomNum = intent.getIntExtra("random", 1)
        imageResource = imageResources[randomNum]
        idValueTV.text = intent.getStringExtra("extra_id")
        mainIV.setImageResource(imageResource)
    }

}