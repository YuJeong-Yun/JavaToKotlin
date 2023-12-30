package ch03.OOP

class K_object키워드 {
}

//////////////////// static 함수와 변수 ////////////////////
// 코틀린에는 static 키워드가 없고, companion object(동행 객체) 사용
class Person5 private constructor(
    var name: String,
    var age: Int,
) {
    // 여기에 있는 변수, 함수가 자바의 static 변수 함수인 것처럼 사용됨
    companion object {
        // 그냥 val은 런타임 시, const 키워드를 앞에 붙이면 컴파일시 변수가 할당됨
        // 즉 const는 진짜 상수에 붙이기 위한 용도. 기본 타입과 String에 붙일 수 있음
        private const val MIN_AGE = 1

        @JvmStatic // 자바에서 코틀린 동행 객체 코드 사용 시 쓰는 애노테이션. 호출은 아래 방법 참조
        fun newBaby(name: String): Person5 {
            return Person5(name, MIN_AGE)
        }
    }
}

// companion object도 하나의 객체로 간주됨. 따라서 이름을 붙일 수도, 인터페이스를 구현할 수도 있음
interface Log {
    fun log()
}

class Person6 private constructor(
    var name: String,
    var age: Int,
) {
    // 여기에 있는 변수, 함수가 자바의 static 변수 함수인 것처럼 사용됨
    companion object Factory : Log {
        // 그냥 val은 런타임 시, const 키워드를 앞에 붙이면 컴파일시 변수가 할당됨
        // 즉 const는 진짜 상수에 붙이기 위한 용도. 기본 타입과 String에 붙일 수 있음
        private const val MIN_AGE = 1
        fun newBaby(name: String): Person6 {
            return Person6(name, MIN_AGE)
        }

        override fun log() {
            println("Peron6 클래스의 동행객체 Factory입니다")
        }
    }
}


// 자바에서 코틀린의 동행 객체 사용 방법
//
/** 이름 없는 동행 객체
 * 1. Person5.Companion.newBaby("aa");
 * 2. @JvmStatic 애노테이션 사용 시 => Person5.newBaby("aa:);
 */
/** 이름 있는 동행 객체
 * 1. Person6.Factory.newBaby("aa");
 * 2. @JvmStatic 애노테이션 사용 시 => Person6.newBaby("aa:);
 */


//////////////////// 싱글톤 ////////////////////
// 앞에 object 키워드만 붙여주면 됨
object Singleton {
    var a: Int = 0
}

fun main() {
    // 싱글톤이므로 인스턴스 생성 없이 바로 접근 가능
    Singleton.a
    Singleton.a += 10
}


//////////////////// 익명 클래스 ////////////////////
// 익명 클래스 : 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
// 자바 : new 타입이름()
// 코틀린 : object : 타입이름

interface Movable {
    fun move()
    fun fly()
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

fun main2() {
    moveSomething(object : Movable {
        override fun move() {
            println("무브 무브")
        }

        override fun fly() {
            println("날다 날다")
        }
    })
}
