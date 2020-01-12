package exam

class PropertyExam01 {
    var allByDefault: Int? // error: explicit initializer required, default getter and setter implied
        set(value) {field = value}
    var initialized = 2 // has type Int, default getter and setter

    val simple: Int? // has type Int, default getter, must be initialized in constructor
    val inferredType = 2 // has type Int and a default getter

    constructor(simple: Int) {
        this.simple = simple
        this.allByDefault = 1;
    }
}

fun main() {
    val p = PropertyExam01(1);
    println(p.inferredType)
    println(p.simple)
    println(p.allByDefault)
    p.allByDefault = 100
    println(p.allByDefault!!)
}