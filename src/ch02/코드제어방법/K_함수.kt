package ch02.코드제어방법

class K_함수 {
    //////////////////// 함수 선언 문법
    // 기본 접근제어자는 public. 생략 가능
    // 반환 타입 생략가능(void와 같은 Unit)
    fun max(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }

    // 위처럼 함수가 하나의 결과값을 반환하면 { }과 return 생략하고 = 사용 가능
    // (= 사용시 가능)반환 결과값 a, b가 모두 Int 이므로 함수 반환 타입 생략 가능
    // { }를 사용하면 반환 타입이 Unit이 아닌 경우는 모두 명시적으로 작성해야함
    fun max2(a: Int, b: Int) =
        if (a > b) {
            a
        } else {
            b
        }

    // 이렇게 한 줄로 변환 가능
    fun max3(a: Int, b: Int) = if (a > b) a else b


    //////////////////// default parameter
    // 함수 파라미터에 = 로 값을 넣어주면 기본값이 됨
    fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
        for (i in 1..num) {
            if (useNewLine) {
                println(str)
            } else {
                print(str)
            }
        }

    }


    fun main() {
        //////////////////// named argument
        // 매개변수 이름을 통해 직접 지정가능
        // 참고로 코틀린에서 자바 함수를 가져다 쓸 때에는 named argument를 사용할 수 없음
        repeat("test", useNewLine = false)


        //////////////////// 가변 인자(같은 타입의 여러 파라미터 받기)
        // vararg 사용 == 자바에서 ...
        fun printAll(vararg strings: String) {
            for (str in strings) {
                println(str)
            }
        }
        // 가변 인자 함수 호출 방법
        // 1. 쉼표
        printAll("A", "B", "C")
        // 2. 배열
        // spread연산자 * = 가변인자에 배열 넣어줄 때는 * 붙여줘야함. 배열 안에 있는 것들을 , 를 쓰는 것처럼 꺼내준다는 의미
        val array = arrayOf("A", "B", "C")
        printAll(*array)
    }


}