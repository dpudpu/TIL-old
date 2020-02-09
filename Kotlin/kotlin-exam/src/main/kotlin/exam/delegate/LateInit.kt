package exam.delegate

class Name(val value: String)

class Person {
    var name: Name? = null
}

class Person2 {
    lateinit var name: Name
}

fun main() {
    val person = Person()
    println(person.name?.value)
    person.name = Name("dpudpu")
    println(person.name?.value)


    val person2 = Person2()
//    println(person1.name) // UninitializedPropertyAccessException: lateinit property name has not been initialized
    person2.name = Name("dpudpu")
    println(person2.name.value)
}
