package com.example.bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //findViewById<어디서>(R.id.아이디 이름) -> 어디서 : 아이디 타입
        //et_height가 변수 heightEditText와 연결함
        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val submitButton = findViewById<Button>(R.id.btn_check)

        //btn_check 눌렀을 때 위 데이터들 넘겨주기
        submitButton.setOnClickListener {
            //데이터 입력하지 않고 확인 버튼을 눌렀을 때 예외처리 해주기
            if(heightEditText.text.isEmpty())    //heightEditText여기에 있는 text가 비어있을 때
            {
                //Toast.makeText(context, text, 유지 시간)
                //신장 값을 입력 안하면 "신장을 입력해주세요"라고 화면에 뜬다.
                Toast.makeText(this, "신장을 입력해주세요!", Toast.LENGTH_SHORT).show()
                //아래 부분이 실행하면 안되기 때문에 리턴해야 한다.
                return@setOnClickListener
            }

            if(weightEditText.text.isEmpty())
            {
                Toast.makeText(this, "체중을 입력해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //heightEditText에서 받아온 문자열을 숫자로 바꿔서 height에 넣기
            val height : Int = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText.text.toString().toInt()

            //액티비티에서 액티비티로 데이터 전송할 때는 intent를 사용한다.
            val intent = Intent(this, ResultActivity::class.java)
            //사용자가 입력한 키와 몸무게를 넘겨줄거다.
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            //mainActivity에서 ResultActivity를 부른거다.
            startActivity(intent)
        }


    }
}
