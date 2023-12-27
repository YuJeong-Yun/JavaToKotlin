package ch02.코드제어방법

//////////////////// 클래스와 프로퍼티
// 생성자 클래스 옆에 작성
//class Person constructor(name: String, age: Int) {
// 여기서 constructor 키워드는 생략 가능
class Person(name: String, age: Int) {
    // 생성자 파라미터에 타입 있으므로 타입은 생략 가능
    val name = name // 불변, 즉 final
    var age = age
}

// 프로퍼티 = 필드 + getter + setter
// 코틀린에서는 필드를 만들면 getter, setter는 자동으로 만들어줌
class K_클래스 {
    fun main() {
        val person = Person("이름", 100)

        // 코틀린에서 getter, setter 호출 시 .필드 로 가져옴
        println(person.name)
        person.age = 10
    }
}

// 코틀린에서는 필드 선언과 생성자를 동시에 선언할 수 있음
// 따라서 아래와 같이 빈 body는 생략하고 표현 가능
class Person2(
    val name: String,
    var age: Int
)

// 코틀린에서 입력 값 검증은 init 블록에서 함. init(초기화) 블록은 생성자가 호출되는 시점에 호출됨
class Person3(
    val name: String,
    var age: Int
) {
    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }

    // 두 번째 생성자 부터는 init 블록 아래에 constructor 키워드와 함께 만들어져야 함
    // this 키워드로 다른 생성자 호출 가능
    // body 있어도 없어도 ok
    constructor(name: String) : this(name, 1) {
        println("부 생성자 1")
    }

    constructor() : this("이름")

    //////////////////// 커스텀 getter, setter
    // 아래와 같이 함수로 만들 수 있지만
    fun isAudult(): Boolean {
        return this.age >= 20
    }

    // 커스텀 getter 사용 가능(마치 Person 클래스에 프로퍼티가 있는 것처럼 보여줌)
    val isAdult: Boolean
        // get 했을 때 어떤 로직을 실행시킬건지 적어줌
        get() = this.age >= 20
    // 커스텀 getter 사용 시 아래와 같이도 표현 가능
    // get() {
    //     return this.age >= 20
    // }
}

// =====>>> 주 생성자는 반드시 존재 해야하지만, 파라미터가 하나도 없다면 생략 가능
// =====>>> 부 생성자는 없어도 OK. but 최종적으로 주 생성자를 this로 호출 해야함 & body를 가질 수 있음
/*
참고로 코틀린은 부 생성자 보다는 default parameter를 권장함.
converting과 같은 경우 부생성자를 사용할 수 있지만, 그보다는 정적 팩토리 메소드를 추천함
*/


// Custom getter를 사용하면 자기 자신을 변형해 줄 수 있다
// custom getter를 사용하기 위해선 생성자말고 따로 선언해줘야함
class Person4(name: String, age: Int) {
    val name = name
        // 자기 자신을 가리키는 field 키워드(backing field) 사용
        // filed 대신 name 넣으면 무한루프 발생
        get() = field.uppercase()

    // but custom getter에서 backing field 쓰는 경우는 드뭄. 아래와 같이 사용 가능
    fun getUpperCaseName(): String {
        return this.name.uppercase()
    }
    val upperCaseName: String
        get() = this.name.uppercase()

    // custom setter
    var name2 = name
        set(value) {
            field = value.uppercase()
        }
}






