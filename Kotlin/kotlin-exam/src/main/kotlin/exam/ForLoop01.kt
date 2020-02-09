package exam

fun main() {
    val items = listOf("apple", "orange", "kiwi")

    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("$index - ${items[index]}")
    }

    items.forEach { x -> println(x) }

}
