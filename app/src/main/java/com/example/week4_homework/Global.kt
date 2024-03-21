package com.example.week4_homework

import android.content.Context
import android.widget.Toast

val imageResources = arrayOf(
    R.drawable.img_1,
    R.drawable.img_2,
    R.drawable.img_3,
    R.drawable.img_4,
    R.drawable.img_5
)
fun getRandomIndex(): Int{
    return (imageResources.indices).random()
}

fun toastFun(context: Context, toast: String){
    Toast.makeText(context,toast, Toast.LENGTH_SHORT).show()
}