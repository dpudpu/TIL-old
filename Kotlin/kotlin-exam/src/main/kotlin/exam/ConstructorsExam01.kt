package exam

fun main() {
    InitOrderDemo("hello")
    val p = Person("ㅁㄴㅇ")
}

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
        println(firstProperty)
    }
}

class Person(val name: String) {
    var children: MutableList<Person> = mutableListOf<Person>();

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }

    constructor(age: Int, name: String, parent: Person) : this(name, parent) {
        parent.children.add(this)
    }
}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}
