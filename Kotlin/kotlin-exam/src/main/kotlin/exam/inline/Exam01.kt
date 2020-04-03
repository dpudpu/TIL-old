package exam.inline

fun main() {

    val listOf = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val startTime = System.currentTimeMillis()

    for (i in 1..10000000) {
        val filter = listOf.filter()
    }

    val finishTime = System.currentTimeMillis()
    println(finishTime - startTime)
}

public  fun <T> Iterable<T>.filter(): List<T> {
    val destination = ArrayList<T>()
    return destination
}

