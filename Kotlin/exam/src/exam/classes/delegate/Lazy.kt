package exam.classes.delegate

class LazyPerson {
    val name: Name by lazy {
        println("init")
        Name("dpudpu")
    }
}

fun main() {
    val lazy = LazyPerson()
    println(lazy.name.value)
    println(lazy.name.value)
}
