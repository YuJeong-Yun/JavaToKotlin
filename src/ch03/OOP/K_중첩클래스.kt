package ch03.OOP

class K_중첩클래스 {
}

//////////////////// 중첩 클래스의 종류 ////////////////////
// 1. static을 사용하는 중첩 클래스 :  클래스 안에 static을 붙인 클래스. 밖의 클래스 직접 참조 불가

// 2. static을 사용하지 않는 중첩 클래스
// 2-1. 내부 클래스 : 클래스 안의 클래스, 밖의 클래스 직접 참조 가능. 즉 바깥의 클래스와 연결되어 있음
// 2-2. 지역 클래스 : 메소드 내부에 클래스 정의
// 2-3. 익명 클래스 : 일회성 클래스

// ** 클래스 안에 클래스를 만들 때는 1. static 클래스 사용을 권장
// 코틀린에서는 그냥 클래스 안에 클래스 생성하면 됨. 기본적으로 바깥 클래스에 대한 연결이 없는 중첩 클래스가 만들어짐
class House(
    private val address: String,
    private val livingRoom: LivingRoom,
) {
    class LivingRoom(
        private val area: Double
    )
}
// 코틀린에서 바깥 클래스를 참조하는 중첩 클래스 2-1. 를 생성할 때는 inner 키워드 추가