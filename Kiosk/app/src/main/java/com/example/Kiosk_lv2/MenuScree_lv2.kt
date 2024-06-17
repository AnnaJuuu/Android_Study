package com.example.Kiosk_lv2


fun main()
{
    while (true)
    {
        println("메뉴 선택해 주세요.")
        println("[1] 버거 [2] 사이드 [3] 음료 [0] 종료")
        var MenuSelection = readLine()!!.toInt()

        when (MenuSelection)
        {
            //입력값이 1번이면 BugerMenu클래스에 있는 bugermenu메서드를 호출한다.
            1 -> BugerMenu().bugerMenu()
            2 -> SideMenu().sideMenu()
            3 -> DrinkMenu().drinkMenu()
            //0번 입력하면 break한다.
            0 -> break
            else -> println("다시 입력해주세요")

        }
    }
}
//피드백 lv3 -> 메뉴 클래스 > 부모 > 상속 세부 메뉴 클래스
