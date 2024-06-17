package com.example.calculatorC_lv2

class `Calculator_lv2`
{
        //AddOperation(더하기), SubstractOperation(빼기),
        //MultiplyOperation(곱하기), DivideOperation(나누기)
        fun AddOperation(num1: Double, num2: Double): Double = num1 + num2
        fun SubstractOperation(num1: Double, num2: Double): Double = num1 - num2
        fun MultiplyOperation(num1: Double, num2: Double): Double = num1 * num2
        fun DivideOperationn(num1: Double, num2: Double): Double = num1 / num2
        fun ModulusOperation(num1: Double, num2: Double): Double = num1 % num2
}

fun main ()
{
        var calculator = Calculator_lv2()
        while(true){
                println("아래 메뉴에서 선택해주세요.")
                println("[1] 더하기 연산 [2] 빼기 연산 [3] 곱하기 연산 [4] 나누기 연산 [5] 나머지 연산 [-1] 종료")
                val input = readLine()!!.toInt()

                if(input == -1) break

                println("첫번 째 숫자를 입력해 주세요.")
                val num1 = readLine()!!.toDouble()

                println("두번 째 숫자를 입력해 주세요. ")
                val num2 = readLine()!!.toDouble()

                val result = if (input == 1)
                {
                        calculator.AddOperation(num1, num2)
                } else if (input == 2)
                {
                        calculator.SubstractOperation(num1, num2)
                } else if (input == 3)
                {
                        calculator.MultiplyOperation(num1, num2)
                } else if (input == 4)
                {
                        calculator.DivideOperationn(num1, num2)
                } else if (input == 5)
                {
                        calculator.ModulusOperation(num1, num2)
                } else break
                println("결과 : ${result}\n")
        }
}
