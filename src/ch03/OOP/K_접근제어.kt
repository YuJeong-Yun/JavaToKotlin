package ch03.OOP

class K_접근제어 {
}

//////////////////// 자바와 코틀린의 가시성 제어 ////////////////////
/** public (동일)
 * 모든 곳에서 접근 가능
 */

/** protected
 *  같은 패키지 / 하위 클래스에서만 접근 가능
 *  >>>
 *  선언된 클래스 / 하위 클래스에서만 접근 가능
 *  (코틀린에서는 패키지를 namespace를 관리하기 위한 용도로만 사용. 즉 just 영역 관리를 위함)
 */

/** default
 * 같은 패키지에서만 접근 가능
 * >>>
 * internal
 * 같은 모듈에서만 접근 가능
 * (모듈 : 한 번에 컴파일 되는 코틀린 코드)
 */

/** private (동일)
 * 선언된 클래스 내에서만 접근 가능
 */

// 자바의 기본 접근 지시어는 default
// 코틀린의 기본 접근 지시어는 public


//////////////////// 코틀린 파일의 접근 제어 ////////////////////
// 코틀린은 파일 내에(클래스 없이) 바로 함수, 변수, 클래스 등 생성 가능
// 이 경우 protected는 사용 불가(선정된 클래스와 하위 클래스에 작동하므로 파일에 바로 작성 불가)
// 생성자에 접근 지시어 붙일 경우 constructor 키워드 사용 필수(기본은 public constructor)
class Dog protected constructor()


//////////////////// 프로퍼티 접근 제어 ////////////////////
// 프로퍼티의 접근 제어 방식 2가지
// 1. 프로퍼티 앞에 붙여서 getter, setter 한 번에 설정
class Car(
    internal val name: String
)

// 2. custom getter / custom setter에 따로 붙여주는 방법
// (getter의 가시성은 프로퍼티의 가시성과 같아야 함!)
class Car2(
    val name: String,
    var owner: String,
    _price: Int
) {
    // 프로퍼티 앞에 접근 지시어 생략되어 있으므로 기본 public
    // 즉 getter는 public이고 setter는 private인 상태
    var price = _price
        private set
}


//////////////////// 자바와 코틀린 함께 사용시 주의점 ////////////////////
// - internal은 바이트 코드 상 public이 된다. 때문에 자바에서는 코틀린 모듈의 internal 코드를 가져올 수 있다
// - 자바는 같은 패키지의 코틀린 protected 멤버에 접근할 수 있다(코틀린과 자바의 protected 범위가 다름)
// ==> 자바에서 코틀린 코드 사용 시 internal과 protected는 주의해야함

