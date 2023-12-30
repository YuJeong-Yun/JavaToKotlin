package ch04.FP

import java.lang.management.PlatformLoggingMXBean

class K_배열과컬렉션 {
}

//////////////////// 배열 ////////////////////
// 참고로 배열보다 리스트 권장
fun main() {
    val array = arrayOf(100, 200)
    // 배열 값 추가
//    array = array.plus(300)

    // < for문으로 배열에 있는 값 출력 방법 >
    // 1. 인덱스를 이용한 방법
    for (i in array.indices) {
        println(array[i])
    }
    // 2. 인덱스와 value를 한 번에 받는 방법
    for ((idx, value) in array.withIndex()) {
        println("${idx}, ${value}")
    }
}


//////////////////// 컬렉션 ////////////////////
// 컬렉션 생성 시 가변인지, 불변인지 설정
/*
* 가변(Mutable) 컬렉션 : 컬렉션에 element 추가 삭제 가능
* 불변 컬렉션 : 컬렉션에 element 추가 삭제 불가
**/

fun main2() {
    //////////////////// List (기본 구현체는 ArrayList)
    // 불변 리스트는 listOf로 생성
    val numbers = listOf(100, 200)
    // 가변 리스트는 mutableListOf로 생성(add, remove, addAll, removeAll 등 사용 가능)
    val numbers2 = mutableListOf(100, 200, 300)
    numbers2.add(400)
    // 비어있는 타입 만들 때는 들어올 타입 명시적으로 적어줘야 함
    val emptyList = emptyList<Int>()

    // 리스트 값 가져오기
    numbers.get(0)
    numbers[0]

    // 리스트 값 출력
    for (number in numbers) {
        println(number)
    }
    for ((idx, value) in numbers.withIndex()) {
        println("${idx}, ${value}")
    }

    //////////////////// Set (기본 구현체는 LinkedHashSet)
    // 기능은 List와 비슷
    val numbers3 = setOf(100, 200)
    val numbers4 = mutableSetOf(100, 200)
    for (number in numbers) {
        println(number)
    }
    for ((index, number) in numbers.withIndex()) {
        println("$index $number")
    }

    //////////////////// Map (기본 구현체는 LinkedHashSet)
    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(0, "SUNDAY")
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"
    // 불변 map 생성
    mapOf(0 to "SUNDAY", 1 to "MONDAY")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap.get(key))
        println(oldMap[key])
    }
    for ((key, value) in oldMap.entries) {
        println("$key $value")
    }
}


//////////////////// 컬렉션의 null 가능성, 자바와 함께 사용하기 ////////////////////
// List<Int?> : 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
// List<Int>? : 리스트에 null이 들어갈 수 없지만, 리스트는 null일 수 있음
// List<Int?>? : 리스트에 null이 들어갈 수 있고, 리스트가 null일 수도 있음

// 코틀린 쪽의 컬렉션이 자바에서 호출되면 컬렉션 내용이 변할 수 있음.(자바는 컬렉션을 가변 불변으로 구분하지 않으므로)
// 코틀린에서 Collections.unmodifableXXX()를 활용해 변경 자체를 막을 수 있음