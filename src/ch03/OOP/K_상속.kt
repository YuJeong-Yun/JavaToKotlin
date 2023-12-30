package ch03.OOP

class K_상속 {}

abstract class Animal(
    protected val species: String,
    // (추상 클래스더라도) 추상 프로퍼티가 아니라면, 자식 클래스에서 getter를 오버라이드 하려면 프로퍼티에 open 키워드 붙여줘야함
    /*
    * final(override 할 수 없게 한다.)이 기본으로 붙어있음.
    * 따라서 클래스, 프로퍼티 등에 open 붙여줘야 오버라이드 가능
    * */
    // abstract 키워드 붙어있으면 반드시 오버라이드 해줘야함. open은 해도 안해도 ok
    protected open val legCount: Int,
) {
    abstract fun move()
}

class Cat(
    species: String
// 상속은 extends 대신 ' : ' 키워드 사용
// 아래처럼 상속받은 부모 클래스() 로 상위 생성자 호출
) : Animal(species, 4) {
    // 오버라이드는 애노테이션 대신 지시어 사용
    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }
}

class Penguin(
    species: String
) : Animal(species, 2) {

    private val wingCount: Int = 2

    override fun move() {
        println("펭권이 움직인다~ 꿱")
    }

    // getter 오버라이드 방법 (오버라이드와 custom getter 사용)
    override val legCount: Int
        get() = super.legCount + this.wingCount
}

interface Flyable {
    // 코틀린에서는 인터페이스에서 default 키워드 없이 메서드 구현 가능
    fun act() {
        println("파닥 파닥")
    }
}

interface Swimable {
    fun act() {
        println("어푸 어푸")
    }
}

class Penguin2(
    species: String
// 인터페이스 구현도 상속과 마찬가지로 ' : ' 키워드 사용
) : Animal(species, 2), Flyable, Swimable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭권이 움직인다~ 꿱")
    }

    // getter 오버라이드 방법 (오버라이드와 custom getter 사용)
    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        // 상위 인터페이스 호출법
        // 자바에서는 Swimable.super.act()
        super<Swimable>.act()
        super<Flyable>.act()
    }
}

// * 클래스 상속받을 때 주의할 점
/*
* - 상위 클래스를 설계할 때 상위 클래스의 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open 사용 X
* - 상위 클래스에서 하위 클래스가 override 하고 있는 프로퍼티를 생성자 블럭이나 init 블럭에서 쓰면 이상한 값이 나올 수 있음
* - 상위 클래스 상속을 구현할 때 생성자를 반드시 호출
* - 추상 멤버가 아니라면 open을 사용해야 오버라이드 가능
* */