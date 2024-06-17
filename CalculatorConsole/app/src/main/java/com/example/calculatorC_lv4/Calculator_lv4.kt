package com.example.calculatorC_lv4

class Calculator_lv4
{
    var operation : AbstractOperation?=null
    fun operate(num1 : Double, num2 : Double) : Double
    {
        return operation!!.operate(num1, num2) //try.. catch..
    }
}

fun main()
{
    val calculator = Calculator_lv4()
    while(true)
    {
        println("아래 메뉴에서 선택해주세요.")
        println("[1] 더하기 연산 [2] 빼기 연산 [3] 곱하기 연산 [4] 나누기 연산 ")
        println("주의 : -1입력시 계산기 바로 종료됩니다.")

        val input = readLine()!!.toInt()
        if (input == -1)
        {
            println("계산기 종료하겠습니다.")
            break
        } else if (input !in 1..4)
        {
            println("잘못된 선택입니다, 다시 입력해주세요\n")
            continue
        }

        println("첫번 째 숫자를 입력해주세요.")
        val num1 = readLine()!!.toDouble()
        if (num1 == -1.0)
        {
            println("계산기 종료하겠습니다.")
            break
        }

        println("두번 째 숫자를 입력해주세요.")
        val num2 = readLine()!!.toDouble()
        if (num2 == -1.0)
        {
            println("계산기 종료하겠습니다.")
            break
        }
        val operation = when(input)
        {
            1 -> AddOperation()
            2 -> SubtractOperation()
            3 -> MultiplyOperation()
            4 -> DivideOperation()
            else -> throw Exception("잘못된 선택입니다.")
        }
        calculator.operation = operation
        println("결과 : ${calculator.operate(num1, num2)}\n")
    }
}