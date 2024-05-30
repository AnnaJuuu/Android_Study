package com.example.bmi_calculator

import android.graphics.Color
import android.os.Bundle
import android.view.TextureView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AppCompatActivity



class ResultActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        //MainActivity에서 보낸 코드를 ResultActivity에서 받기
        //유저가 메인에서 입력한 신장, 몸무게 값이 결과 페이지로 넘겨줌
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        //BMI 계산
        var BMIvalue = weight / (height/100.0).pow(2.0)
        BMIvalue = round(BMIvalue*10)/10

        var resultText =""
        var resImage = 0
        var resColor = 0

        if(BMIvalue < 18.5)
        {
            resultText = "저체중"
            resImage = R.drawable.lv2
            resColor = Color.YELLOW
        } else if (BMIvalue >= 18.5 && BMIvalue < 23.0)
        {
            resultText = "정상체중"
            resImage = R.drawable.lv1
            resColor = Color.GREEN
        } else if (BMIvalue >= 23.0 && BMIvalue < 25.0)
        {
            resultText = "과제중"
            resImage = R.drawable.lv3
            resColor = Color.BLACK
        } else if (BMIvalue >= 25.5 && BMIvalue < 30.0)
        {
            resultText = "경도 비만"
            resImage = R.drawable.lv4
            resColor = Color.CYAN
        } else if (BMIvalue >= 30.0 && BMIvalue < 35.0)
        {
            resultText = "중정도 비만"
            resImage = R.drawable.lv5
            resColor = Color.MAGENTA
        } else
        {
            resultText = "고도 비만"
            resImage = R.drawable.lv6
            resColor = Color.RED
        }

        //아이디들 찾아서 변수에 연결하기
        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_restText)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val btn_back = findViewById<Button>(R.id.btn_back)

        //tv_resValue에 계산한 값을 넣어주기
        tv_resValue.text = BMIvalue.toString()
        tv_resText.text = resultText
        iv_image.setImageResource(resImage)
        tv_resText.setTextColor(resColor)

        //돌아가기 누르면 바로 종료
        btn_back.setOnClickListener {
            finish()
        }


    }

}