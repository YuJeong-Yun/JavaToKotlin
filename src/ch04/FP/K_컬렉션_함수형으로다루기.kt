package ch04.FP

class K_컬렉션_함수형으로다루기 {
}

//////////////////// 필터와 맵 ////////////////////
// filter
val apples = fruits.filter { fruit -> fruit.name == "사과" }

// filterIndexed = 인덱스가 필요한 경우
val apples2 = fruits.filterIndexed { idx, fruit ->
    println(idx)
    fruit.name == "사과"
}

// map
val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
    .map { fruit -> fruit.currentPrice }

// mapIndexed = map에서 인덱스가 필요한 경우
val applePrices2 = fruits.filter { fruit -> fruit.name == "사과" }
    .mapIndexed { idx, fruit ->
        println(idx)
        fruit.currentPrice
    }

// mapNotNull = mapping의 결과가 null이 아닌 것만 가져오고 싶다면
val applePrices3 = fruits.filter { fruit -> fruit.name == "사과" }
    .mapNotNull { fruit -> fruit.nullOrValue() }


// 저번 강의 함수 filter 이용해 아래처럼 표현 가능
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    return fruits.filter(filter)
}


//////////////////// 필터와 맵 /////////////////////
// all = 조건을 모두 만족하면 true 그렇지 않으면 false
val isAllApple = fruits.all { fruit -> fruit.name == "사과" }

// none = 조건을 모두 불만족하면 true 그렇지 않으면 false
val isNoApple = fruits.none { fruit -> fruit.name == "사과" }

// any = 조건을 하나라도 만족하면 true 그렇지 않으면 false
val isNoApple1 = fruits.any { fruit -> fruit.price >= 10_000 }

// count = 개수를 센다 (==List의 size와 같다고 보면 됨)
val fruitCount = fruits.count()

// sortedBy = (오름차순) 정렬
// sortedByDescending = (내림차순) 정렬
val fruitCount1 = fruits.sortedBy { fruit -> fruit.price }

// distinctBy = 변형된 값을 기준으로 중복을 제거
// 이름을 기준으로 중복 제거 후 -> 이름만 남김
val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
    .map { fruit -> fruit.name }

// frist = 첫번째 값을 가져옴(무조건 null이 아니어야함)
// firstOrNull = 첫번째 값 또는 null을 가져온다
// last = 마지막 값을 가져옴(무조건 null이 아니어야함)
// lastOrNull = 마지막 값 또는 null을 가져온다
fun main() {
    fruits.first()
    fruits.firstOrNull()
    fruits.last()
    fruits.lastOrNull()
}


//////////////////// List를 Map으로 /////////////////////
// groupBy
// 과일 이름이 키고, 해당하는 과일들이 List로 들어있는 Map
val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }

// associateBy =  value에 단일 객체가 들어감
// 중복되지 않는 키를 가지고 맵을 만들 때 사용함 (id 등 가지고..)
val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }

// 과일 이름을 기준으로 리스트 출고가를 맵으로 만듦
val map3: Map<String, List<Int>> = fruits
    .groupBy({ fruit -> fruit.name }, { fruit -> fruit.price })

// id -> 출고가 Map이 필요
val map4: Map<Long, Int> = fruits
    .associateBy({ fruit -> fruit.id }, { fruit -> fruit.price })

// map에 대해서도 앞선 기능 대부분 사용 가능
// 사과 리스트만 담긴 맵
val map5: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    .filter { (key, value) -> key == "사과" }


//////////////////// 중첩된 컬렉션 처리 /////////////////////
// 리스트 안에 리스트가 있는 자료 구조
val fruitsInList: List<List<Fruit>> = listOf(
    listOf(
        Fruit(1L, "사과", 1_000),
        Fruit(2L, "사과", 1_000),
        Fruit(3L, "사과", 1_000),
        Fruit(4L, "사과", 1_000),
    ),
    listOf(
        Fruit(5L, "사과", 1_000),
        Fruit(6L, "사과", 1_000),
        Fruit(7L, "사과", 1_000),
    ),
    listOf(
        Fruit(8L, "사과", 1_000),
    ),
)

// flatMap = list<list>가 단일 list로 바뀜
val samePriceFruits = fruitsInList.flatMap { list ->
    list.filter { fruit -> fruit.price == fruit.currentPrice }
}

// 위 코드에서 중첩된 람다를 아래와 같이 리팩토링 가능
// 우선 확장 함수 만들기
val List<Fruit>.somePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)

fun main6() {
    // 하나의 람다를 쓰는 것처럼 보여주게 리팩토링
    val samePriceFruits2 = fruitsInList.flatMap { list -> list.somePriceFilter }
}

fun main7() {
    // flatten = 중첩돼 있는 컬렉션 중첩 해제. (List<List<Fruit>>를 List<Fruit>로 바꿈)
    fruitsInList.flatten()
}