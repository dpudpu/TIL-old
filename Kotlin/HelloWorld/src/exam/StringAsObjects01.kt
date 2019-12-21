package exam

/**
 * This task will show you some functions of strings. You may already know them. Anyway, it will be great if you solve this problem!

The task here is to decode a string:

If the string's first symbol is i, remove the first symbol. The string will contain a number. Print the number + 1.
If the string's first symbol is s, remove the first symbol. Then print the reversed remainder.
Otherwise, just print the unchanged string.
Here are string functions that you can use:

.first() returns the first symbol of the string.
.isEmpty() returns true, if the string has no symbols, otherwise, it returns false.
.drop(n) removes n first symbols from the string and returns the resulting string.
.reversed() returns the reversed string.
.toInt() converts the string to an integer and returns it.
You should output results using the println function.
 */
fun main() {
    val input = readLine()!!

    var result = input

    if (input.isEmpty()) {
        println(result)
        return
    }
    if (input.first() == 'i') {
        result = (input.drop(1).toInt() + 1).toString()
    }
    if (input.first() == 's') {
        result = input.drop(1)
        result = result.reversed()
    }
    println(result)
}