package com.example.Kiosk_lv3

//전역 변수 사용 잘 안함 -> 캠슐화 (객체지향 프로그래밍)
//확장 함수
class Manager  //products를 관리하는 Manager
{
    //mutable 가능한 list -> 그냥 list read-only
    //메뉴 틀 수정가능한 mutableListOf()먼저 만들어 놓음
    //외부에서 참조할 필요 없음 -> private
    private val products: MutableList<Food> = mutableListOf()  //지역 변수
    //상황에 따라 사용, 신상 init!!!
    init {  //최초 무조건 실행, init에서 초기화는 코틀린에서만 가능.
        with(products) //스코프 함수!!
        {
            add(BugerMenu("빅맥", 5.8))
            add(BugerMenu("상하이 버거", 5.8))
            add(BugerMenu("불고기 버거", 5.0))

            add(SideMenu("감자튀김", 2.8))
            add(SideMenu("치즈스틱", 2.6))
            add(SideMenu("아이스크림", 2.3))

            add(DrinkMenu("콜라", 1.5))
            add(DrinkMenu("사이다", 1.5))
            add(DrinkMenu("환타", 1.5))
        }
    }

    fun screen() {
        while (true) {
            val selectProdut: MutableList<Food> = mutableListOf()

            val menuSelect = arrayListOf("[1] 버거", "[2] 사이드", "[3] 음료", "[0] 종료")
            println("아래 메뉴를 선택해 주세요.")
            for (menu in menuSelect) //배열이 가지고 있는 값의 수 만큼 반복하여 메뉴를 화면에 출력
            {
                println(menu)
            }

            var inputSelect = ExceptionHandling().input("menuSelect")

            when (inputSelect) {
                1 -> {
                    println("버거 메뉴를 선택해주세요.")
                    //filterIsInstanc -> 특정 타입의 원소만 담는 확장 함수
                    products.filterIsInstance<BugerMenu>()
                        .forEach {
                            println(it.toMenu())
                            selectProdut.add(it)
                        } //변수 범위에 대해서 알아보기!
                }


                2 -> {
                    println("사이드 메뉴를 선택해주세요.")
                    products.filterIsInstance<SideMenu>()
                        .forEach {
                            println(it.toMenu())
                            selectProdut.add(it)
                        }
                }

                3 -> {
                    println("음료 메뉴를 선택해주세요.")
                    products.filterIsInstance<DrinkMenu>().forEach {
                        println(it.toMenu())
                        selectProdut.add(it)
                    }
                }

                0 -> break
                else -> println("다시 입력해 주세요.")
            }
            var menuchoice = ExceptionHandling().input("menuSelect")

            when (menuchoice)
            {
                1 -> println("${selectProdut[0].name} 선택하셨습니다. ${selectProdut[0].price}원입니다. ")

                2 -> println("${selectProdut[1].name} 선택하셨습니다. ${selectProdut[1].price}원입니다. ")

                3 -> println("${selectProdut[2].name} 선택하셨습니다. ${selectProdut[2].price}원입니다. ")
            }
        }
    }
}