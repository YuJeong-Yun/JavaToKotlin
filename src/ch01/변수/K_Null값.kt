package ch01.변수

class K_Null값 {
    fun main() {
        ////////// Safe Call
        // null이 아니면 실행하고, null이면 실행하지 않는다(결과값은 그대로 null)
        val str: String? = null
        str.length // 불가능
        str?.length // 가능

        ////////// Elvis 연산자
        // 앞의 연산 결과가 null이면 뒤의 값을 사용
        str?.length ?: 0

        ////////// 플랫폼 타입
        // = 코틀린이 null 관련 정보를 알 수 없는 타입(ex. 자바에서 코드 가져와서 쓸 때)
        // -> Runtime시 Exception 발생할 수 있음
        // 따라서 Kotlin에서 Java코드를 사용할 때 플랫폼 타입 사용에 유의해야함

    }

    fun startWithA1(str: String?): Boolean {
//        if (str == null) {
//            throw IllegalArgumentException("null이 들어왔습니다")
//        }
//        return str.startsWith("A")

        return str?.startsWith("A")
            ?: throw IllegalArgumentException("null이 들어왔습니다")

    }

    fun startWithA2(str: String?): Boolean? {
//        if (str == null) {
//            return null
//        }
//        return str.startsWith("A")

        return str?.startsWith("A")
    }

    fun startWithA3(str: String?): Boolean {
//        if (str == null) {
//            return false
//        }
//        return str.startsWith("A")

        return str?.startsWith("A") ?: false
    }

    ////////// early Return에서 Elvis 연산자 사용
    fun test(number: Long): Long {
        // if (number == null) {
        //     return 0;
        // }
        // ~~다음 로직

        number ?: return 0
        // ~~디음 로직
    }

    ////////// 널 아님 단언 (ex.nullable인 필드가 업데이트 후 null이 될 수 없는 필드로 바뀐 경우)
    // !! : null이 아닌게 확실한 경우만 사용
    fun startWith(str: String?): Boolean {
        return str!!.startsWith("A")
    }

}