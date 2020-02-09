package exam

fun main() {
    val crew = Crew.of("bedi", 20)
    println("${crew.name} is ${crew.age}. ${Crew.CAPTAIN}")
}

class Crew private constructor(val name: String, val age: Int) {
    companion object{
        val CAPTAIN = "POBI";

        fun of(name: String, age: Int): Crew {
            return Crew(name, age)
        }
    }
}
