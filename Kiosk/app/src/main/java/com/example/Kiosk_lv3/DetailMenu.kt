package com.example.Kiosk_lv3

//데이터 저장하는 용도
//data class -> 변수가 있어야함
data class BugerMenu(val bugerName : String, val bugerPrice : Double) : Food(bugerName, bugerPrice)

data class SideMenu(val sideName : String, val sidePrice : Double) : Food(sideName, sidePrice)

data class DrinkMenu(val drinkName : String, val drinkPrice : Double, ) : Food(drinkName, drinkPrice)