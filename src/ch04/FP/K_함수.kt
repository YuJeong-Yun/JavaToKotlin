package ch04.FP

class K_함수 {
}

//////////////////// 확장 함수 ////////////////////
// 확장함수 : 클래스 밖에 있지만 클래스 안에 있는 메서드처럼 호출해서 사용
// 확장함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없다

// String 클래스 안에 있는 것 같은 확장함수
fun String.lastChar(): Char {
    // 함수 안에서 this(=수신 객체)를 통해 인스턴스에 접근 가능
    return this[this.length - 1]
}

fun main() {
    val str = "abc"
    println(str.lastChar())
}


//////////////////// 중위 함수 ////////////////////
// 중위함수 : 함수를 호출하는 새로운 방법 (ex. downTo, step 등)
// 변수.함수이름(argument)
// >>> 중위함수로
// 변수 함수이름 argument

fun Int.add(other: Int): Int {
    return this + other
}

// infix 키워드 앞에 붙임
infix fun Int.add2(other: Int): Int {
    return this + other
}

fun main3() {
    3.add(4)

    3.add2(4)
    3 add2 4 // 중위 함수 호출
}


//////////////////// inline 함수 ////////////////////
// inline 함수 : 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복사
inline fun Int.add3(other: Int): Int {
    return this + other
}
// add3 함수를 호출하면 덧셈 로직 자체가 함수를 부르는 쪽에 복사됨
// 함수를 파라미터로 전달할 때 오버헤드를 줄일 수 있다


//////////////////// 지역 함수 ////////////////////
// 지역 함수 : 함수 안에 함수를 선언할 수 있다
// 함수로 추출하면 좋을 것 같은데(ex.중복 코드 부분) 이 함수를 지금 함수 내에서만 사용하고 싶을 때
// but depth가 깊어지기도 하고, 코드가 깔끔하지 않으므로 자주 사용 x
fun createPerson(firstName: String, lastName: String): Person {
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다! 현재 값 : $name")
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}

class Person(firstName: String, lastName: String, age: Int)