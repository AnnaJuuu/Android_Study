package com.example.Kiosk_lv3

class ExceptionHandling
{
    fun input(type : String) : Any
    {
        return when(type) {
            "menuSelect" -> {
                println("메뉴 선택해주세요.")
                while (true) {
                    try {
                        var menuSelect: Int = readLine()!!.toInt()
                        if (menuSelect in 0..3) return menuSelect
                    } catch (e: NumberFormatException)  //입력 값이 한글, 영문 등의 잘못된 입력값이면 int로 변환할 수 없기 때문에 에러 발생
                    {
                        println("다시 입력해주세요. ")
                    }
                }
            }
            else -> println("잘못된 값입니다.")
        }
    }
}