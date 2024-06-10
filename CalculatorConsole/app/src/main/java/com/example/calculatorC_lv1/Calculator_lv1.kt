package com.example.calculatorC_lv1

class Calculator_lv1  //연산 메서드들 class Calculator에 저장
{
    var num1 : Double = 0.0  //함수 인자 num1을 Double형으로 지정 후 초기화
    var num2 : Double = 0.0  //함수 인자 num2을 Double형으로 지정 후 초기화
    var operator : String = ""  //연산 하기위한 변수 operator String으로 지정

    //AddOperation(더하기), SubstractOperation(빼기),
    //MultiplyOperation(곱하기), DivideOperation(나누기)
    fun AddOperation (num1 : Double, num2 : Double) : Double = num1 + num2
    fun SubstractOperation (num1 : Double, num2 : Double) : Double = num1 - num2
    fun MultiplyOperation (num1 : Double, num2 : Double) : Double = num1 * num2
    fun DivideOperationn (num1 : Double, num2 : Double) : Double = num1 / num2

}


fun main()
{
    //Calculator_lv1 클래스의 인스턴스를 생성
    //생성된 calculator는 Calculator_lv1 클래스의 객체가 된다.
    val calculator = Calculator_lv1()

    println("첫번 째 숫자를 입력해 주세요.")
    //num1을 입력하기, !!절때 null이 나오지 않을거다, Double형으로 형변환
    //변환된 Double 값을 calculator 객체의 num1 변수에 저장
    calculator.num1 = readLine()!!.toDouble()

    println("원하는 연산자를 입력해 주세요.")
    calculator.operator = readLine()!!.toString()

    println("두번 째 숫자를 입력해 주세요.")
    calculator.num2 = readLine()!!.toDouble()

    //when구문 사용하여 calculator객체의 operator 값에 따라 아래 코드들 실행한다
    //실행한 결과를 result라는 변수에 저장
    val result = when(calculator.operator)
    {
        "+" -> calculator.AddOperation(calculator.num1, calculator.num2)
        "-" -> calculator.SubstractOperation(calculator.num1, calculator.num2)
        "/" -> calculator.MultiplyOperation(calculator.num1, calculator.num2)
        "*" -> calculator.DivideOperationn(calculator.num1, calculator.num2)
        //위 지정한 연산을 선택하지 않은 경우 아래 문구를 출력한다.
        else -> "잘못된 연산자입니다."
    }
    println("결과 = ${result}") //결과 반환하기
}



/*
개인적으로 Calculator_lv1 클래스의 인스턴스를 생성하지 않고 사용하면 너무 비효율적이라 아래 코드를 쓰지 않았습니다.
fun main()
{
    println("첫번 째 숫자를 입력해 주세요.")
    var num1 :Double = readLine()!!.toDouble()

    println("원하는 연산자를 입력해 주세요.")
    var operator :String = readLine()!!.toString()

    println("두번 째 숫자를 입력해 주세요.")
    var num2 :Double = readLine()!!.toDouble()

    var result :Double = 0.0

        when(operator)
    {
    //각 연산자에 따라 Calculator 클래스의 인스턴스를 생성하여 해당 메서드를 호출
    //하지만 이 코드는 매번 연산이 필요할 때마다 Calculator 클래스의 새로운 인스턴스를 생성하고 있다.
        "+" -> {result = Calculator().AddOperation(num1, num2)}
        "-" -> {result = Calculator().SubstractOperation(num1, num2)}
        "*" -> {result = Calculator().MultiplyOperation(num1, num2)}
        "/" -> {result = Calculator().DivideOperationn(num1, num2)}
            else -> {"잘못된 연산자입니다."
            Double.NaN}
    }
    println("결과 : ${result}")
}
 */