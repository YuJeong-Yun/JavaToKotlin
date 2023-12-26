package ch01.변수

import java.time.temporal.TemporalAmount
import javax.print.attribute.standard.MediaSize.Other

data class Money(
    val amount: Long
) {
    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }
}

class K_연산자 {
    fun main() {
        ////////// 비교 연산자
        // 코틀린에선는 객체에 비교 연산자를 사용하면 자동으로 compareTo를 호출함
        val money1 = JavaMoney(2_000L)
        val money2 = JavaMoney(1_000L)

        if (money1 > money2) {
            println("money1이 money2보다 금액이 큽니다")
        }

        // 동등성 : 두 객체의 값이 같은가
        // 동일성 : 완전히 동일한 객체인가 = 즉 주소가 같은가
        // 자바에서는 동일성에 ==, 동등성에 equals 호출
        // 코틀린에서는 동일성에 ===, 동등성에 == 호출 (== 사용하면 간접적으로 equals 호출해줌)


        ////////// 코틀린에 있는 특이한 연산자
        // in, !in : 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다
        // a..b : a부터 b까지 범위 객체를 생성한다
        // a[i] : a에서 특정 인덱스(i) 값 가져온다
        // a[i] = b : a의 특정 인덱스(i)에 값을 넣는다


        ////////// 연산자 오버로딩
        // 코틀린에서는 객체마다 연산자를 직접 정의할 수 있음
        val m1 = Money(1_000L)
        val m2 = Money(2_000L)
        // plus 연산자 대신 실제 '+' 기호 사용 가능
        println(m1.plus(m2))
        println(m1 + m2)
    }
}