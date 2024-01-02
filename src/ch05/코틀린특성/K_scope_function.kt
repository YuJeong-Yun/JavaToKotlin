package ch05.코틀린특성

//////////////////// scope function ////////////////////
// scope function = 일시적인 영역을 형성하는 함수
// => 람다를 사용해 일시적인 영역을 만들고, 코드를 더 간결하게 만들거나 method chaning에 활용하는 함수를 말함
// 종류 : let / run / also / apply / with(with 제외 모두 확장함수)

//                  it사용       this사용
// 람다의 결과 반환      let          run
// 객체 그 자체 반환     also        apply
// with(파라미터, 람다) = this를 사용해 접근. this는 생략 가능

// this = 생략 가능 / 다른 이름 붙일 수 없음 (확장 함수에서 본인 자신을 this로 호출하고, 생략할 수 있었음)
// it = 생략 불가능 / 다른 이름 붙일 수 있음


fun printPerson(person: Person?) {
    if (person != null) {
        println(person.name)
        println(person.age)
    }
    // let = 확장함수. 람다를 받아, 람다 결과를 반환
    person?.let {
        println(it.name)
        println(it.age)
    }
}


//////////////////// 언제 어떤 scope function을 사용해야할까 ////////////////////
/** 1. let */
fun main() {
// - 하나 이상의 함수를 call chain 결과로 호출할 때
    val strings = listOf("APPLE", "CAR")
    strings.map { it.length }
        .filter { it > 3 }
        .let(::println)
// - non-null 값에 대해서만 code block을 실행시킬 때 (**가장 많이 사용**)
    val str = "abc"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }
// - 일회성으로 제한된 영역에 지역 변수를 만들 때
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if (firstItem.length >= 5) firstItem else "!$firstItem!"
        }.uppercase()
    println(modifiedFirstItem)
}

/** 2. run */
fun main4() {
// - 객체 초기화와 반환 값의 계산을 동시에 해야 할 때
//    ex) 객체를 만들어 DB에 바로 저장하고, 그 인스턴스를 활용할 때
//    val person = Person(" 최태현", 100).run(personRepository::save)
//    val person = Person("최태현", 100).run {
//        hobby = "독서"
//        personRepository.save(this)
//    }
    // but 아래처럼 더 자주 씀
    // 반복되는 생성 후처리는 생성자, 프로퍼티, init block으로 넣는 것이 좋다
//    val person = personRepository.save(Person("이름", 100))
}

/** 3. apply */
fun main5() {
    // - 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때
    // 객체 생성 시에는 필요 없는데, 후에 값이 필요할 때(아래 예시에서 hobby)
    fun createPerson(
        name: String,
        age: Int,
        hobby: String,
    ): Person {
        return Person(
            name = name,
            age = age,
        ).apply {
            this.hobby = hobby
        }
    }
}

/** 4. also */
fun main6() {
    // - 객체를 수정하는 로직이 call chain 중간에 필요할 때
    mutableListOf("one", "two", "three")
        .also { println("four 추가 이전 지금 값: $it") }
        .add("four")
    // 그냥 아래처럼 써도 됨
    val numbers = mutableListOf("one", "two", "three")
    println("The list elements before adding new one: $numbers")
    numbers.add("four")
}

/** 5. with */
fun main7() {
    // - 특정 객체를 다른 객체로 변환해야 하는데, 모듈 간의 의존성에 의해
    // 정적 팩토리 혹은 toClass함수를 만들기 어려울 때

    // 아래처럼 this를 생략할 수 이씨어 필드가 많아도 코드가 간결해진다
//    return with(person) {
//        PersonDto(
//            name = name,
//            age = age,
//        )
//    }
}


//////////////////// scope function과 가독성 ////////////////////
// 사용 빈도가 적은 관용구는 코드를 더 복잡하게 만들고 이런 관용구들을 한 문장 내에서 조합해 사용하면 복잡성이 훨씬 증가