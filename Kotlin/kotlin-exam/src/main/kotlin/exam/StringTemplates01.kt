package exam

fun main() {
    val city = "paris"
    println("i live $city")
    println("paris is ${city.length} letters")

    val s = "string"
    println("$s.first()" == "string.first()")
    println("${s.first()}" == "s")
}
