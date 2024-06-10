package com.example.calculatorC_lv3

class AddOperation(num1 : Double , num2 : Double) : baseOperation(num1, num2)
{
    override fun operate(): Double = num1 + num2
}