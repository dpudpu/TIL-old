package exam.classes.delegate

class MemberMap(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun main() {
    val MemberMap = MemberMap(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))
}
