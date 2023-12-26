package ch02.코드제어방법

class K_제어문 {
    //////////////////// if문
    // 자바에서 if-else는 Statement이지만,  코틀린에서는 Expression이다.
    // Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다
    // Expression : 하나의 값으로 도출되는 문장
    // Statement > Expression
    // 코틀린에서는 if문 값 반환 가능. 대신 삼항연산자 없음
    fun getPassOrFail(score: Int): String {
        // 자바에서는
        if (score >= 50) {
            return "P"
        } else {
            return "F"
        }
        // 코틀린에서는
        return if (score >= 50) {
            "P"
        } else {
            "F"
        }
    }


    //////////////////// switch와 when
    // 자바의 switch => 코틀린의 when
    fun getGrade(score: Int): String {
        return when (score / 10) {
            9 -> "A"
            8 -> "B"
            7, 6 -> "C"
            else -> "0"
        }
        // 아래와 같이 값 대신 조건부 사용 가능
        return when (score) {
            in 90..99 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else -> "0"
        }
        // 값 없이도 가능
        val number = 10
        return when {
            number == 0 -> "숫자는 0입니다."
            number % 2 == 0 -> "짝수입니다."
            else -> "홀수입니다."
        }
    }

    // 조건부 사용 예시
    fun startsWith(obj: Any): Boolean {
        return when (obj) {
            is String -> obj.startsWith("A")
            else -> false
        }
    }

}