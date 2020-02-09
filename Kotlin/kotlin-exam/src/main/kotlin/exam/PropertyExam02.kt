package exam

class PropertyExam02 {
    private var _table: String? = null
    public val table: String
        get() {
            if (_table == null) {
                _table = String() // Type parameters are inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }
}

fun main() {
    val p = PropertyExam02()
    println(p.table)
}
