package exam.function

fun read(b: Int, off: Int = 0) {
    println("$b $off")
}

open class A {
    open fun foo(i: Int = 10) { /*...*/ }
}

class B : A() {
    override fun foo(i: Int ) { println(i) }  // no default value allowed
}

fun main() {
    read(1)
    B().foo()
}
