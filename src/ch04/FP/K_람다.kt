package ch04.FP

class K_람다 {
}

//////////////////// 람다 ////////////////////
// 함수는 자바에서는 2급 시민이지만, 코틀린에서는 1급 시민이다.
// => 코틀린은 자바와는 다르게 함수가 그 자체로 값이 될 수 있다
// => 변수에 할당할 수도, 파라미터로 넘길 수도 있다
class Fruit(val name: String, val price: Int) {
    constructor(id: Long, name: String, price: Int) : this(name, price) {
        this.id = id
    }

    val currentPrice: Int = price
    var id: Long = 0L

    // 18강 참조...
    fun nullOrValue(): Int? {
        return 0
    }

    val isSamePrice: Boolean
        get() = price == currentPrice
}


val fruits = listOf(
    Fruit("사과", 1_000),
    Fruit("사과", 1_200),
    Fruit("사과", 1_200),
    Fruit("사과", 1_500),
    Fruit("바나나", 3_000),
    Fruit("바나나", 3_200),
    Fruit("바나나", 2_500),
    Fruit("수박", 10_000),
)

// 람다를 만드는 방법 2가지
// 1.
// 함수 이름이 없음 => 이름 없는 함수(람다)
val isApple = fun(fruit: Fruit): Boolean {
    return fruit.name == "사과"
//    return 생략해도 ok. 람다에서는 마지막 줄이 반환값이 됨
//    fruit.name == "사과"
}
// 변수의 타입 => Fruit를 받아 Boolean을 반환하므로 아래와 같음
// 함수의 타입: (파라미터 타입..) -> 반환 타입
// val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
//     return fruit.name == "사과"
// }

// 2.
val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

// 람다를 호출하는 방법 2가지
fun main() {
    // 1.
    isApple(fruits[0])
    // 2. invoke를 명시적으로 작성
    isApple.invoke(fruits[0])
}

// filter 파라미터 => 함수 타입 자체를 파라미터에 선언
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

fun main4() {
    filterFruits(fruits, isApple)

    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })
    // (마지막 파라미터가 함수인 경우)소괄호 밖의 중괄호가 함수를 호출할 때 마지막 파라미터로 들어감
    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    // 익명 함수 사용 시 파라미터가 한 개 이면 그냥 it 으로 사용 가능
    filterFruits(fruits) { it.name == "사과" }
}


//////////////////// Closure ////////////////////
// 자바에서는 람다를 쓸 때 람다 밖의 변수는 final, 혹은 실질적으로 final인 변수만 사용 가능
// Closure : 람다가 실행되는 시점에 쓰고 있는 변수들을 모두 포획한 데이터 구조
// => 코틀린에서는 Closure를 사용하여 non-final 변수도 람다에서 사용할 수 있다.