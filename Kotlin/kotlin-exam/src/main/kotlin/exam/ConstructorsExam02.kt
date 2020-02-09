package exam

fun main() {
    val customer1 = Customer("edan")
    val customer2 = Customer()
    val customer3 = Customer("moomin", 30)
    customer1.name
}

class Customer(val name: String = "daejun", val age: Int = 20) {
    init {
        println("$name - $age")
    }
}
