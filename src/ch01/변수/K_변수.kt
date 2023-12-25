package ch01.변수

////////// Kotlin코드 자바 코드로 변환 방법
// Tools -> Kotlin -> Show Kotlin ByteCode
// decompile 클릭하면 Java로 변환된 코드 확인 가능

class K_변수 {
    fun main() {
        ////////// 변수 선언 키워드
        // var : 가변 <-> val : 불변(final과 유사)
        // 타입은 의무적으로 작성할 필요 없음
        var num1: Long = 10L
        val num2 = 10L

        ////////// nullable 변수
        // 기본적으로 null 값 못 가짐.
        var num3: Long? = 1_000L
        num3 = null

        ////////// 인스턴스 생성
        var person = Person("김")
    }

}
