package com.example.calculatorC_lv2

class `Calculator_lv2`
{
        var num1: Double = 0.0
        var num2: Double = 0.0

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
        while(true){
                //1~5번의 선택 사항 콘솔에 출력
                println("아래 메뉴에서 선택해주세요.")
                println("[1] 더하기 연산 [2] 빼기 연산 [3] 곱하기 연산 [4] 나누기 연산 [5] 나머지 연산")
                println("주의 : -1입력시 계산기 바로 종료됩니다.")

                //위에 선택 사항이 입력되면 input변수에 저장된다.
                val input = readLine()!!.toInt()
                //첫 선택부터 -1이 입력되면 바로 break
                if(input == -1)
                {
                        println("계산기 종료합니다.")
                        break
                }

                //사용자가 input값을 1에서 5번 사이에 입력하면 아래 코드가 실행된다.
                if(input in 1..5)
                {
                        println("첫번 째 숫자를 입력하세요.")
                        var num1 = readLine()!!.toDouble()
                        //num1에 -1이 입력 되면 바로 break
                        if(num1 == -1.0)
                        {
                                println("계산기 종료됩니다.")
                                break
                        }

                        println("두번 째 숫자를 입력하세요.")
                        var num2 = readLine()!!.toDouble()
                        if(num2 == -1.0)
                        {
                                println("계산기 종료됩니다.")
                                break
                        }

                        //사용자의 input값에 따라 아래 코드가 실행한다.
                        val result = when(input)
                        {
                                1 -> Calculator_lv2().AddOperation(num1, num2)
                                2 -> Calculator_lv2().SubstractOperation(num1, num2)
                                3 -> Calculator_lv2().MultiplyOperation(num1, num2)
                                4 -> Calculator_lv2().DivideOperationn(num1, num2)
                                5 -> Calculator_lv2().ModulusOperation(num1, num2)
                                else -> { println("잘못된 값입니다. 다시 입력해 주세요.")
                                        continue  //-1 나올 때까지 계속 반복한다.
                                }
                        }
                        println("결과 : ${result}\n")
                }
        }
}



/*do while문
fun main()
{
        do {
                //1~5번의 선택 사항 콘솔에 출력
                println("아래 메뉴에서 선택해주세요.")
                println("[1] 더하기 연산 [2] 빼기 연산 [3] 곱하기 연산 [4] 나누기 연산 [5] 나머지 연산")
                println("주의 : -1입력시 계산기 바로 종료됩니다.")

                //위에 선택 사항이 입력되면 input변수에 저장된다.
                val input = readLine()!!.toInt()
                //첫 선택부터 -1이 입력되면 바로 break
                if (input == -1) {
                        println("계산기 종료합니다.")
                        break
                }

                //사용자가 input값을 1에서 5번 사이에 입력하면 아래 코드가 실행된다.
                if (input in 1..5) {
                        println("첫번 째 숫자를 입력하세요.")
                        var num1 = readLine()!!.toDouble()
                        //num1에 -1이 입력 되면 바로 break
                        if (num1 == -1.0) {
                                println("계산기 종료됩니다.")
                                break
                        }

                        println("두번 째 숫자를 입력하세요.")
                        var num2 = readLine()!!.toDouble()
                        if (num2 == -1.0) {
                                println("계산기 종료됩니다.")
                                break
                        }


                        //사용자의 input값에 따라 아래 코드가 실행한다.
                        val result = when (input) {
                                1 -> Calculator_lv2().AddOperation(num1, num2)
                                2 -> Calculator_lv2().SubstractOperation(num1, num2)
                                3 -> Calculator_lv2().MultiplyOperation(num1, num2)
                                4 -> Calculator_lv2().DivideOperationn(num1, num2)
                                5 -> Calculator_lv2().ModulusOperation(num1, num2)
                                else -> {
                                        println("잘못된 값입니다. 다시 입력해 주세요.")
                                        continue  //-1 나올 때까지 계속 반복한다.
                                }

                        }
                        println("결과 : ${result}\n")
                }
        }while(true)
}*/