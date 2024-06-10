package com.example.calculatorC_lv3

//단일책임원칙 : 설계 원칙 중 하나, 클래스 또는 모듈이 하나의 기능 또는 책임만 가져야 한다는 것을 의미 = 객체지향 프로그래밍
open class baseOperation(val num1 : Double, val num2 : Double)
{
    open fun operate() : Double = 0.0
}

fun main()
{
    while(true)
    {
        println("아래 메뉴에서 선택해주세요.")
        println("[1] 더하기 연산 [2] 빼기 연산 [3] 곱하기 연산 [4] 나누기 연산 ")
        println("주의 : -1입력시 계산기 바로 종료됩니다.")

        val input = readLine()!!.toInt()

        if(input == -1)
        {
            println("계산기 종료합니다.")
            break
        }

        println("첫번 째 숫자를 입력하세요.")
        val num1 = readLine()!!.toDouble()
        if(num1 == -1.0)
        {
            println("계산기 종료합니다.")
            break
        }

        println("두번 째 숫자를 입력하세요.")
        val num2 = readLine()!!.toDouble()
        if(num2 == -1.0)
        {
            println("계산기 종료합니다.")
            break
        }

        val result = when (input)
        {
            1 -> AddOperation(num1, num2).operate()
            2 -> SubtractOperation(num1, num2).operate()
            3 -> MultiplyOperation(num1, num2).operate()
            4 -> DivideOperation(num1, num2).operate()
            else -> {println("잘못된 선택입니다.")}
        }

        println("결과 : ${result}\n")
    }
}

