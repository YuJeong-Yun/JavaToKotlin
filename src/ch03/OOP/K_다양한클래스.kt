package ch03.OOP

class K_다양한클래스 {
}

//////////////////// Data Class ////////////////////
// data class 에는 자동으로 equals, hashCode, toString을 만들어준다.
// (jdk16부터) 자바에서 코틀린의 data class 같은 record class 도입
data class PersonDto(
    val name: String,
    val age: Int,
)


//////////////////// Enum Class ////////////////////
// enum class는 클래스 상속 불가 / 인터페이스는 구현 가능 / 각 코드가 싱글톤(enum에서 필드 하나하나)
enum class Country(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US")
}

// 코틀린에서 enum에 대한 분기 처리를 할 때 when을 사용해서 읽기 쉬운 코드로 바꿀 수 있음
// 컴파일러가 country의 모든 타입을 알고 있어 다른 타입에 대한 로직(else)을 작성하지 않아도 됨
private fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}


//////////////////// Sealed Class, Sealed Interface ////////////////////
// - 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다. 즉 런타임 때 클래스 타입이 추가될 수 없다
// - 하위 클래스는 sealed class와 같은 패키지에 있어야 한다.
// - enum과 다른 점
//      1. 클래스를 상속받을 수 있다
//      2. 하위 클래스는 멀티 인스턴스가 가능하다

