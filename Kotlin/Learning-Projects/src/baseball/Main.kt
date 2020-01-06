package baseball

import java.util.*
import kotlin.random.Random

/**
 * 퀄리티 신경쓰지말고 일단 구현
 */
fun main() {
    val computerNums = makeComputerNumbers()
    println(computerNums)


    do {
        var strike = 0
        var ball = 0
        val inputNumbers = inputNumbers()

        for (x in 0..2 step 1) {
            if (computerNums.get(x) == inputNumbers.get(x)) {
                strike++
            } else if (computerNums.contains(inputNumbers.get(x))) {
                ball++
            }
        }
        println("$strike 스트라이크 $ball 볼")
    } while (strike != 3)
}

fun makeComputerNumbers(): String {
    var nums = ""
    while (nums.length < 3) {
        val num = Random.nextInt(1, 10).toString()
        if (!nums.contains(num)) {
            nums += (num)
        }
    }
    return nums
}

fun inputNumbers(): String {
    print("숫자를 입력하세요: ")
    val scanner = Scanner(System.`in`)
    return scanner.nextLine()
}