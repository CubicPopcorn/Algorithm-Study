fun main() {
    val remains = mutableSetOf<Int>()
    repeat(10) {
        val remain = readln().toInt() % 42
        remains.add(remain)
    }
    println(remains.size)
}