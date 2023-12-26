package ch02.코드제어방법

class K_반복문 {
    fun main() {
        //////////////////// for each문
        val numbers = listOf(1L, 2L, 3L)
        for (number in numbers) {
            println(number)
        }


        //////////////////// 전통적인 for문
        // step 생략하면 기본 증감값 1
        for (i in 1..5 step 2) {
            println(i)
        }
        // 값이 감소하는 경우는
        for (i in 3 downTo 1) {
            println(i)
        }


        //////////////////// while문
        var i = 1
        while (i <= 3) {
            println(i)
            i++
        }
    }
}