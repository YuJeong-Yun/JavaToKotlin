package ch05.코틀린특성

import ch04.FP.Fruit
import kotlin.reflect.typeOf

//////////////////// Type Alias ////////////////////
// 타입 별칭 지정 가능
typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {
}

data class UltraSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>


//////////////////// as import ////////////////////
// 다른 패키지의 같은 이름 함수를 동시에 가져오고 싶을 경우
// as import : 어떤 클래스나 함수를 임포트 할 때 이름을 바꾸는 경우
// import ch04.FP.somePriceFilter as fun1
// import ch04.FP.isApple as fun2


//////////////////// 구조 분해 ////////////////////
// 구조 분해 : 복합적인 값을 분해하여 여러 변수를 한 번에 초기화하는 것(componentN 함수 이용)

// data class는 가지고 있는 필드에 대해 componentN 이라는 함수를 자동으로 만들어줌
// componentN = N번째 프로퍼티를 가져옴
data class Person(val name: String, val age: Int)

fun main() {
    val person = Person("이름", 100)
    val (name, age) = person
    // 아래 두 문장을 합친 것이 위 문장
//    val name = person.component1()
//    val age = person.component2()
}

// data 클래스가 아닌데 구조분해를 사용하고 싶다면, componentN 함수를 직접 구현해줄 수 있다
class Person2(
    val name: String,
    val age: Int
) {
    // componentN 함수를 연산자의 속성을 가지고 있어서 operator 키워드 붙여줘야함
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}


//////////////////// jump와 label ////////////////////
// return = 가장 가까운 enclosing function 또는 익명함수로 값이 반환된다
// break = 가장 가까운 루프가 제거된다
// continue = 가장 가까운 루프를 다음 step으로 보낸다

// forEach = 함수형과 함께 마지막 끝 혹은 중간에 반복적으로 루프를 돌고 싶을 때 사용
// 여기서 continue, break는 사용 불가
fun main2() {
    val numbers = listOf(1, 2, 3)
    val es = numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }

    // forEach와 break를 굳이 쓰고 싶으면 아래처럼 사용.
    run {
        numbers.forEach { number ->
            if (number == 2) {
                return@run
            }
        }
    }
    // forEach와 continue 굳이 쓰고 싶으면 아래처럼 사용
    numbers.forEach { number ->
        if (number == 2) {
            return@forEach
        }
    }
}

// label = 특졍 espression에 라벨이름@을 붙여 하나의 라벨로 간주하고 break, continue, return 등을 사용하는 기능
fun main3() {
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@loop
            }
            println("${i} ${j}")
        }
    }
}

// ** label을 사용한 jump는 사용하지 않는 것을 권장


//////////////////// TakeIf와 TakeUnless ////////////////////
// takeIf = 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null이 반환된다
val number = 0
fun getNumberOrNull(): Int? {
    return if (number <= 0) {
        null
    } else {
        number
    }
}

// takeIf를 사용하면
fun getNumberOrNull2(): Int? {
    return number.takeIf { it > 0 }
}

// takeUnless = 주어진 조건을 만족하지 않으면 그 값이, 그렇지 않으면 null이 반환된다
fun getNumberOrNull3(): Int? {
    return number.takeUnless { it <= 0 }
}