package exam

import java.util.*

fun main() {
//    val input = "23 59 59 12 12 2018"
//
//    val split = input.split(" ")
//    println("${split[0]}:${split[1]}:${split[2]} ${split[3]}/${split[4]}/${split[5]}")

    val scanner = Scanner(System.`in`)
    // write your code here
    val split = scanner.nextLine().split(" ")
    println("${split[0]}:${split[1]}:${split[2]} ${split[3]}/${split[4]}/${split[5]}")
}