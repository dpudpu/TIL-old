package exam.delegate

import kotlin.properties.Delegates.vetoable

var max: Int by vetoable(0) { property, oldValue, newValue ->
    newValue > oldValue
}

fun main() {
    println(max) // 0

    max = 10
    println(max) // 10

    max = 5
    println(max) // 10
}
