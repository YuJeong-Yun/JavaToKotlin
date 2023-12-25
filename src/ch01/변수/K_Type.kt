package ch01.변수

class K_Type {
    ////////// 기본 타입
    // 코틀린은 선언된 기본값을 보고 타입을 추론
    val number1 = 3 // Int
    val number2 = 3L // Long
    val number3 = 3.0f // Float
    val number4 = 3.0 // Double

    // 기본 타입간의 변환 "명시적으로" 이루어져야 함
    // to변환타입() 사용
    val num1 = 3
    val num2: Long = num1.toLong()


    ////////// 타입 캐스팅
    // is, !is, as, as?
    fun printAgeIfPerson(obj: Any) {
//        // 자바의 instanceof == is (참고로 !is 가능)
//        if (obj is Person2) {
//            // as = 참조변수 타입 캐스팅
//            // 해당 타입아니면 예외 발생
//            val person = obj as Person2
//            println(person.age)
//        }

        // 스마트 캐스트 = 코틀린 컴파일러가 if에서 타입 체크하면 해당 타입으로 간주될 수 있음을 인지
        // => 형변환 필요 없음
        if (obj is Person2) {
            println(obj.age)
        }
    }

    // 만약 obj에 null이 들어올 수 있다면
    fun printAgeIfPerson2(obj: Any?) {
        // as? = Safe Call 처럼 null값 들어오면 null값 반환 && Type 아니어도 null 반환
        val person = obj as? Person2
        println(person?.age)
    }

    ////////// Kotlin의 특이한 타입 3가지
    // 1. Any
    /*
    * - 자바의 Object 역할 (모든 객체의 최상위 타입)
    * - 모든 기본 타입의 최상위 타입도 Any
    * - Any 자체는 null 포함 X. null을 포함하고 싶으면 Any? 사용
    * - Any에 equals, hashCode, toString 존재
    * */

    // 2. Unit
    /*
    * - Java의 void와 동일한 역할
    * - void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능
    * - 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미. 즉 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현
    * */

    // 3. Nothing
    /*
    * - 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
    * - 무조건 예외를 반환하는 함수 / 무한 루프 함수 등에 Nothing 으로 표시
    * fun fail(msg: String): Nothing {
    *   throw IllegalArgumentException(msg)
    * }
    * */

    fun main() {
        ////////// String interpolation / String indexing
        val person = Person2("이름", 100)
        val log = "이름은 ${person.name} 이고 나이는 ${person.age}입니다."
        // $변수명 도 사용 가능하지만 ${} 가 가독성 측면에서 나음

        // 문자열 여러줄 작성은 """ 사용
        val str = """
            ABCD
            EFG
        """.trimIndent()

        // 문자열의 특정 문자 가져오기
        str[0]
        str[2]
    }


}