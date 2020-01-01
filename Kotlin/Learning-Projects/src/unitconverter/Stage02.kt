package unitconverter

import java.util.*

fun main() {
    val scanner  = Scanner(System.`in`)
    print("Enter a number of kilometers: ")
    val killometers = scanner.nextInt()
    val meters = killometers * 1000
    print("$killometers kilometers is $meters meters")
}