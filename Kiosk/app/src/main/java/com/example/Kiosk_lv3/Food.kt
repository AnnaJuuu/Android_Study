package com.example.Kiosk_lv3

//입력값 id, 푸드 이름, 가격, 설명
open class Food(val name : String, val price : Double)
{
    fun toMenu(): String
    {
        return "메뉴 이름은 : ${name}, ${price}"
    }
}
