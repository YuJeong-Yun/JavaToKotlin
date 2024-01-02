package ch04.FP

class Fruit(val name: String, val price: Int) {
    constructor(id: Long, name: String, price: Int) : this(name, price) {
        this.id = id
    }

    val currentPrice: Int = price
    var id: Long = 0L

    // 18강 참조...
    fun nullOrValue(): Int? {
        return 0
    }

    val isSamePrice: Boolean
        get() = price == currentPrice
}