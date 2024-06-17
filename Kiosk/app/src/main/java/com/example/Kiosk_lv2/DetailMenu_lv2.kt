package com.example.Kiosk_lv2


//음료 메뉴
class DrinkMenu
{
    fun drinkMenu()
    {
        println("음료를 선택해 주세요. ")
        println("[1] 콜라 [2] 사이다 [3] 환타 [0] 돌아가기")
        //예외 처리 InputNumber 클래스에서 inputNuber 메서드를 호출하여
        //사용자가 입력한 값을 검사한 후 리턴하여 변수 BugerSelection에 저장한다.
        val BugerSelection = exceptionHandling().input("menuSelect")

        when (BugerSelection)
        {
            1 -> println("콜라 선택하셨습니다.")
            2 -> println("사이다 선택하셨습니다.")
            3 -> println("환타 선택하셨습니다.")
            0 -> return  //리턴은 drinkMenu메서드에서 빠져 나간다.
            else -> { println("다시 입력해 주세요. ") }

        }
    }
}


//버거 메뉴
class BugerMenu
{
    fun bugerMenu()
    {
        println("버거를 선택해 주세요. ")
        println("[1] 빅맥 [2] 상하이 버거 [0] 돌아가기")
        val BugerSelection = exceptionHandling().input("menuSelect")

        return if (BugerSelection == 1) println("빅맥 버거 선택하셨습니다.")
        else if(BugerSelection == 2) println("상하이 버거 선택하셨습니다.")
        else return
    }
}


//사이드 메뉴
class SideMenu
{
    fun sideMenu()
    {
        println("사이드를 선택해 주세요. ")
        println("[1] 감자취김 [2] 치즈스틱 [0] 돌아가기")
        val BugerSelection = exceptionHandling().input("menuSelect")

        return if (BugerSelection == 1) println("감자튀김 선택하셨습니다.")
        else if(BugerSelection == 2) println("치즈스틱 선택하셨습니다.")
        else return
    }
}