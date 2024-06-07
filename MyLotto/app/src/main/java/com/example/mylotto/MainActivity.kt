package com.example.mylotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    //private알아보기, by lazy알아보기!!!!!
    //먼저 클릭버튼과 넘버픽을 선언해준다.
    private val clearButton by lazy { findViewById<Button>(R.id.btn_clear) }
    private val addButton by lazy { findViewById<Button>(R.id.btn_add) }
    private val runButton by lazy { findViewById<Button>(R.id.btn_run) }
    private val numPick by lazy { findViewById<NumberPicker>(R.id.np_num) }

    //6개의 공을 하나씩 꺼내서 쓸 수 있도록 먼저 리스트 형태로 만들기
    //numTextViewList: List<TextView>, listOf<TextView>알아보기!!!!!
    private val numTextViewList: List<TextView> by lazy {
        listOf<TextView>(
            findViewById(R.id.tv_num1),
            findViewById(R.id.tv_num2),
            findViewById(R.id.tv_num3),
            findViewById(R.id.tv_num4),
            findViewById(R.id.tv_num5),
            findViewById(R.id.tv_num6)
        )
    }

    //run 상태인지 체크하는 변수가 필요함
    //필요하는 이유는 뒤에서 설명함
    //처음에 실행하지 않기 때문에 초기값은 false다.
    private var didRun = false
    //사용자가 지정하는 숫자를 담아둘 공간이 필요
    //hashSetOf 알아보기!!
    private val pickNumSet = hashSetOf<Int>()


    //onCreate가 발생하면 activity_main화면이 안드로이드 폰에 띄워진다.
    //앱이 시작하는 곳!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //numpick의 최대값, 최소값을 줘야한다.
        //min, max 알아보기!!
        numPick.minValue = 1
        numPick.maxValue = 45

        //버튼 함수 3개 호출해주기
        initAddButton()
        initRunButton()
        initClearButton()
    }

    //initAddButton() 부르면 아래 부분이 호출 된다.
    private fun initAddButton() {
        addButton.setOnClickListener {
            // addButton이 눌렸을 때 아래 코드가 실행이 된다.
            when {
                //자동 생성 버튼을 눌렀을 때 아래 문구를 보여준다.
                //showToast 아래에 함수 생성
                didRun -> showToast("초기화 후에 시도해주세요.")

                //5개 이상 더 추가 하려고 할 때 아래 문구를 보여준다.
                pickNumSet.size >= 5 -> showToast("숫자는 최대 5개까지 선택할 수 있습니다.")

                //숫자 중복하는 경우 아래 문구를 보여준다.
                //countains 알아보기!!!!!
                pickNumSet.contains(numPick.value) -> showToast("이미 선택한 숫자입니다.")
                else -> {
                    //예외 끝난 후 else에 공 동작 추가
                    //size 알아보기!!!!
                    val textView = numTextViewList[pickNumSet.size]
                    textView.isVisible = true
                    textView.text = numPick.value.toString()

                    setNumBack(numPick.value, textView)
                    pickNumSet.add(numPick.value)
                }
            }
        }
    }

    private fun setNumBack(number: Int, textView: TextView) {
        val background = when (number) {
            in 1..10 -> R.drawable.circle_yellow
            in 11..20 -> R.drawable.circle_blue
            in 21..30 -> R.drawable.circle_red
            in 31..40 -> R.drawable.circle_gray
            else -> R.drawable.circle_green
        }
        textView.background = ContextCompat.getDrawable(this, background)
    }

    private fun initClearButton() {
        clearButton.setOnClickListener {
            pickNumSet.clear()
            numTextViewList.forEach { it.isVisible = false }
            didRun = false
            numPick.value = 1
        }
    }

    private fun initRunButton() {
        runButton.setOnClickListener {
            val list = getRandom()
            didRun = true

            list.forEachIndexed { index, number ->
                val textView = numTextViewList[index]
                textView.text = number.toString()
                textView.isVisible = true
                setNumBack(number, textView)
            }
        }
    }

    private fun getRandom(): List<Int> {
        val numbers = (1..45).filter { it !in pickNumSet }
        return (pickNumSet + numbers.shuffled().take(6 - pickNumSet.size)).sorted()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}