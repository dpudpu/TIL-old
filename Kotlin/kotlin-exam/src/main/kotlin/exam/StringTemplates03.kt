package exam

/**

Sample Input 1:
John Smith 30

Sample Output 1:
J. Smith, 30 years old

Sample Input 2:
Reece Weber 20

Sample Output 2:
R. Weber, 20 years old
 */
fun main() {
    val expected = "J. Smith, 30 years old";
    val input = "John Smith 30"

    val split = input.split(" ")
    val output = "${split[0].first()}. ${split[1]}, ${split[2]} years old"
    println(output)
    println(output == expected)
}
